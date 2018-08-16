package com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.R;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.BaseActivity;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.Bean.News;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.NewslvAdapter;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.dagger.MainActivityModule;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view.presenter.MainPresenter;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.myApp.MyAppComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.lv_show)
    ListView lvShow;
//    @Inject
    NewslvAdapter newslvAdapter;
    @Inject
    MainPresenter mainPresenter;
    private List<News.NewslistBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter.getNews();
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("tag", "onItemClick: "+data.get(position).getUrl());
            }
        });
    }

    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void setupComponent(MyAppComponent myAppComponent) {
        DaggerMainActivityComponent.builder().myAppComponent(myAppComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }

    @Override
    public void onSuccess(News news) {
        data=news.getNewslist();
        newslvAdapter=new NewslvAdapter(this,data);
        lvShow.setAdapter(newslvAdapter);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
