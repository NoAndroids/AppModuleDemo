package com.shy.constraintlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
/**
 * constraint-layout 约束布局
 * 1.在sdk-tool中下载SDK
 * 2.在build.gradle 中添加依赖
 * 3.必须使用AS  2.2以上的版本
 * 4.将父布局替换为constraint-layout
 *
 *
 * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
