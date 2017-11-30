package com.shy.servertest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.io.File;

public class DownLoadService extends Service {
    private DownLoadTask downLoadTask;
    private String downloadUrl;

    private DownLoadListener loadListener = new DownLoadListener() {
        @Override
        public void onProgress(int progess) {
            getNotificationManager().notify(1, getNotification("DownLoading..", progess));
        }

        @Override
        public void onSuccess() {
            downLoadTask = null;
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("DownLoad Success", -1));
            Toast.makeText(DownLoadService.this, "DownLoad Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            downLoadTask = null;
            Toast.makeText(DownLoadService.this, "DownLoad Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            downLoadTask = null;
            Toast.makeText(DownLoadService.this, "DownLoad Paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            downLoadTask = null;
            stopForeground(true);
            Toast.makeText(DownLoadService.this, "DownLoad Canceled", Toast.LENGTH_SHORT).show();
        }
    };

    private DownLoadBinder mBinder = new DownLoadBinder();

    class DownLoadBinder extends Binder {
        public void startDown(String url) {
            if (downLoadTask == null) {
                downloadUrl = url;
                downLoadTask = new DownLoadTask(loadListener);
                downLoadTask.execute(downloadUrl);
                startForeground(1, getNotification("DownLoading...", 0));
            }
        }
        public  void pauseDownLoad(){
            if (downLoadTask!=null){
                downLoadTask.pauseDownLoad();
            }

        }
        public void cancelDownLoad(){
            if (downLoadTask!=null){
                downLoadTask.cancelDownLoad();
            }else{
                if (downLoadTask!=null){
                    String fileName=downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                    String directory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file=new File(directory+fileName);
                    if (file.exists()){
                        file.delete();
                    }
                    getNotificationManager().cancel(1);
                    stopForeground(true);
                    Toast.makeText(DownLoadService.this,"Canceled",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    public DownLoadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNotification(String title, int progress) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle(title);
        if (progress > 0) {
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
            builder.setAutoCancel(true);
        }
        return builder.build();

    }
}
