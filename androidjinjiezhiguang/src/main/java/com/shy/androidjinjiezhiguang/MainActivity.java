package com.shy.androidjinjiezhiguang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    //recycleView
    private RecyclerView recyclerView;
    private HomeAdapter mHomeAdapter;
    private List<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            data.add(i+"");
        }
        recyclerView=findViewById(R.id.rv);
        mHomeAdapter=new HomeAdapter(data,this);
        mHomeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Log.i("tag", "onItemClick: "+postion);
            }

            @Override
            public void onItemLongClick(View view, int postion) {
                mHomeAdapter.removeItem(postion);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mHomeAdapter);
    }
}
