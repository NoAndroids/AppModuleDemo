package com.shy.servertest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }
    private DownLoaderBinder downLoaderBinder=new DownLoaderBinder();
    class DownLoaderBinder extends Binder{
        public  void startDownLoad(){
            Log.i("tag", "startDownLoad: ");
        }
        public int getDownLoad(){
            Log.i("tag", "stopDownLoad: ");
            return 0;
        }


    }
    @Override
    public void onCreate() {
        //创建的时候调用
        super.onCreate();
        Intent in=new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,in,0);
        Notification notification= new NotificationCompat.Builder(this)
                .setContentTitle("title")
                .setContentText("text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //每次启动的时候调用
        new Thread(new Runnable() {
            @Override
            public void run() {
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //服务销毁的时候调用
        super.onDestroy();

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return downLoaderBinder;
    }
}
