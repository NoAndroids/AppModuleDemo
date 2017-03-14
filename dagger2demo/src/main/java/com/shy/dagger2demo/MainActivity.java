package com.shy.dagger2demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    /**
     * 1添加插件
     * 在工程中添加
     * 添加android-apt 插件
     * classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
     * 在APP中添加配置
     * 应用插件
     * apply plugin: 'com.neenbedankt.android-apt'
     * dagger 2 的配置
     * compile 'com.google.dagger:dagger:2.4'
     * apt 'com.google.dagger:dagger-compiler:2.4'
     * compile 'org.glassfish:javax.annotation:10.0-b28'// 添加java 注解库
     * <p>
     * 2.Dagger2的目的是将程序分为三个部分。
     * - 实例化部分：对象的实例化。类似于容器，将类的实例放在容器里。 mainmodule
     * - 调用者：需要实例化对象的类。  activity
     * - 沟通桥梁：利用Dagger2中的一些API 将两者联系。  maincomponent
     */
    @Inject  //标明注入的对象
    Person person;
    @Inject
    Person person2;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        // 构造桥梁对象
//        MainComponent mainComponent = DaggerMainComponent.builder().mainModule(new MainModule()).build();

        //注入
//        mainComponent.inject(this);
        /**
         * 过程 1.创建 component 并注入方法
         *      2.查找当前类中的带有@inject的成员变量
         *      3.根据成员变量的类型从module中查找哪个有@provides注解的方法的返回值类型为当前的类型
         *
         *      如果讲module中的带有@provides的方法注释后 在person类的构造方法上假如@inject注释，该对象同样能够被创建
         *      流程：先判读module中是否提供该对象的实例化方法如果有则返回结束
         *           如果没有，则查找该类中的构造方法是否带有@inject，如果存在则返回
         * */

        //单例注解
        /**
         * 1.首先在module中实例方法前加入@Singleton 同时conmponent也要加上 否则编译不通过
         */
//        Log.e("dagger2", "onCreate: " + person.hashCode() + "===========" + person2.hashCode());

        /**
         * 在不同的activity中是否同样单例？
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
