package com.shy.appmoduledemo;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shy.baseutillib.BaseActivity;
import com.shy.one.oneActivity;

//
public class MainActivity extends BaseActivity {
Button one,two;

    /***
     * 组件化开发  1.正常启动的application的组件  可以包括启动页 首页等
     *            2.一个base 的lib  可以包括所有的base类  如baseactivity 等 所有的lib都依赖这个lib
     *              还可以将各种工具类放入到这个lib中
     *            3.各个模块的lib  各自完成自己模块的功能  更具需要 依赖其他的lib
     *            4.baselib 依赖的gradle  具有穿透性  其他的lib 不用在依赖了
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one= (Button) findViewById(R.id.one);
        two= (Button) findViewById(R.id.two);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=getStartActivityIntent("com.shy.one.oneActivity");
                Intent  intent=new Intent(MainActivity.this,oneActivity.class);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getStartActivityIntent("com.shy.two.twoActivity");
                startActivity(intent);
            }
        });

    }

    /**
     * 获取项目中的资源文件
     * */
    public Resources getBaseResources() {
        return getResources();
    }

    public Intent getStartActivityIntent(String ActivityName) {
        Intent intent = new Intent();
        intent.setClassName(this, ActivityName);
        return intent;
    }
}
