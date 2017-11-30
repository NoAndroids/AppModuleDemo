package com.shy.qunyingzhuan;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tongzhi extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongzhi);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Tongzhi.this,RecyclerViewActivity.class);
                PendingIntent intent1=PendingIntent.getActivity(Tongzhi.this,0,intent,0);
                NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification= new NotificationCompat.Builder(Tongzhi.this)
                        .setContentTitle("tongzhi")
                        .setContentText("contenttext")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(intent1)
                        .setAutoCancel(true) //自动取消
//                        .setSound() 提示音
                        .setVibrate(new long[]{1000,0,1000})//数组下标 0表示静止 1 震动  2静止  以此类推  需要权限
                        .setLights(Color.GREEN,1000,1000)//呼吸灯
                        .setDefaults(NotificationCompat.DEFAULT_ALL)//默认当前手机情况
                        .build();
                manager.notify(1,notification);
            }
        });
    }
}
