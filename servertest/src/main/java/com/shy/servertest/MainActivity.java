package com.shy.servertest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start, btn_stop;
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.DownLoaderBinder downLoaderBinder= (MyService.DownLoaderBinder) service;
                    downLoaderBinder.startDownLoad();
                    downLoaderBinder.getDownLoad();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.start);
        btn_stop = (Button) findViewById(R.id.stop);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
//                Intent intent = new Intent(this, MyService.class);
//                startService(intent);
                Intent intent=new Intent(this,MyService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.stop:
//                Intent stopintent = new Intent(this, MyService.class);
//                stopService(stopintent);
                unbindService(serviceConnection);
                break;
        }
    }
}
