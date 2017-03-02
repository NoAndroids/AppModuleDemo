package com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.myApp.MyApp;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.myApp.MyAppComponent;

import butterknife.ButterKnife;

public abstract  class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        ButterKnife.bind(this);
        setupComponent(MyApp.getMyapp(this).getMyAppComponent());
    }
    public  abstract int getViewId();
    public  abstract void setupComponent(MyAppComponent myAppComponent);
}
