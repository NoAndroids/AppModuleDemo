package com.shy.servertest;

import android.app.DownloadManager;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * Created by ShangHongYu on 2017/11/29.
 */

public class DownLoadTask extends AsyncTask<String,Integer,Integer> {
    public static final int TYPE_SUCCESS=0;
    public static final int TYPE_FAILED=1;
    public static final int TYPE_PAUSED=2;
    public static final int TYPE_CANCELED=3;
    private DownLoadListener downLoadListener;

    private boolean isCanceled=false;
    private boolean isPaused=false;
    private int lastProgess;

    public DownLoadTask(DownLoadListener downLoadListener) {
        this.downLoadListener = downLoadListener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream inputStream=null;
        RandomAccessFile saveFile=null;
        File file=null;
        try{
            long downLoadedLength=0;//记录文件长度
            String downLoadUrl=params[0];
            String fileName=downLoadUrl.substring(downLoadUrl.lastIndexOf("/"));
            String directory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file=new File(directory+fileName);
            if (file.exists()){
                downLoadedLength=file.length();
            }
            long contentLenght=getContentLength(downLoadUrl);
            if (contentLenght==0){
                return TYPE_FAILED;
            }else if(contentLenght==downLoadedLength){
                return TYPE_SUCCESS;
            }
            OkHttpClient okHttpClient=new OkHttpClient();
            Request request=new Request.Builder().addHeader("RANGE","bytes="+downLoadedLength+"-")
                    .url(downLoadUrl)
                    .build();
            Response response=okHttpClient.newCall(request).execute();
            if (response!=null){
                inputStream=response.body().byteStream();
                saveFile=new RandomAccessFile(file,"rw");
                saveFile.seek(downLoadedLength);//跳过已下载的字节
                byte[] b=new byte[1024];
                int total=0;
                int len;
                while ((len=inputStream.read(b))!=-1){
                    if (isCanceled){
                        return  TYPE_CANCELED;
                    }else if (isPaused){
                        return TYPE_PAUSED;
                    }else {
                        total+=len;
                        saveFile.write(b,0,len);
                        int progress=(int)((total+downLoadedLength)*100/contentLenght);
                        publishProgress(progress);
                    }
                }
                response.body().close();
                return  TYPE_SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

                try {
                    if (inputStream!=null) {
                        inputStream.close();
                    }
                    if (saveFile!=null){
                        saveFile.close();
                    }
                    if (isCanceled&& file!=null){
                        file.delete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();

            }
        }
        return TYPE_FAILED;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress=values[0];
        if (progress>lastProgess){
            downLoadListener.onProgress(progress);
            lastProgess=progress;
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer){
            case TYPE_SUCCESS:
                downLoadListener.onSuccess();
                break;
            case TYPE_CANCELED:
                downLoadListener.onCanceled();
                break;
            case TYPE_FAILED:
                downLoadListener.onFailed();
                break;
            case TYPE_PAUSED:
                downLoadListener.onPaused();
                break;
            default:
                break;
        }
    }
    public void pauseDownLoad(){
        isPaused=true;

    }
    public void cancelDownLoad(){
        isCanceled=true;
    }
    private long getContentLength(String downLoadUrl) throws IOException{
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(downLoadUrl)
                .build();
        Response response=okHttpClient.newCall(request).execute();
        if (response !=null && response.isSuccessful()) {
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }
        return 0;


    }
}
