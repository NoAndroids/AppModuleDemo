package com.shy.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {
    @Inject
    Person person;
    @Inject
    Person person2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DaggerMain2Component.builder().mainModule(new MainModule()).build().inject(this);
    }
}
