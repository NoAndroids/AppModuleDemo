package com.shy.androidjinjiezhiguang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ToolBarActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
