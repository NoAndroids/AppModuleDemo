package com.shy.servertest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DownLoadActivity extends AppCompatActivity implements View.OnClickListener {
    private Button start,pause,cancel;
    private DownLoadService.DownLoadBinder binder;
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder= (DownLoadService.DownLoadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        start= (Button) findViewById(R.id.startdown);
        pause= (Button) findViewById(R.id.pausedown);
        cancel= (Button) findViewById(R.id.cancel_down);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        cancel.setOnClickListener(this);
        Intent intent=new Intent(this,DownLoadService.class);
        startService(intent);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        if (binder==null){
            return;
        }
        switch (v.getId()){
            case R.id.startdown:
                String url="http://scimg.jb51.net/allimg/150713/14-150G31G222950.jpg";
                binder.startDown(url);
                break;
            case R.id.pausedown:
                binder.pauseDownLoad();
                break;
            case R.id.cancel_down:
                binder.cancelDownLoad();
                break;
        }
    }
}
