package com.shy.qunyingzhuan;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class F1 extends AppCompatActivity {
    private View1 view1;
    private Topbar topbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);
        view1= (View1) findViewById(R.id.view1);
        topbar= (Topbar) findViewById(R.id.topbar);
        topbar.setTopbarClickListener(new Topbar.topbarClickListener() {
            @Override
            public void leftClick() {
                Log.i("shy", "leftClick: ");
            }

            @Override
            public void rightClick() {
                Log.i("shy", "rightClick: ");
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

}
