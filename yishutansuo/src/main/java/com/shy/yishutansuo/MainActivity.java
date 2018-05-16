package com.shy.yishutansuo;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Context contex;
    private Activity a;
    private Application application;
//    private ListView lv;
    private Handler handler;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        lv= (ListView) findViewById(R.id.lv);
//        Animation animation=AnimationUtils.loadAnimation(this, R.anim.anim3);
//        LayoutAnimationController layoutAnimationController=new LayoutAnimationController(animation);
//        layoutAnimationController.setDelay(0.5f);
//        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        lv.setLayoutAnimation(layoutAnimationController);
        btn1= (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ObjectAnimator.ofFloat(btn1,"translationY",btn1.getHeight()).start();
//                ValueAnimator colorAnimator=ObjectAnimator.ofInt(btn1,"backgroundColor",0xffff8080,0xff8080ff);
//                colorAnimator.setDuration(3000);//时间
//                colorAnimator.setEvaluator(new ArgbEvaluator());
//                colorAnimator.setRepeatCount(ValueAnimator.INFINITE);//次数 -1表示无限循环
//                colorAnimator.setRepeatMode(ValueAnimator.REVERSE);//反转颜色
//                colorAnimator.start();
                AnimatorSet set=new AnimatorSet();
                set.playTogether(ObjectAnimator.ofFloat(btn1,"rotationX",0,360),
                        ObjectAnimator.ofFloat(btn1,"rotationY",0,180),
                        ObjectAnimator.ofFloat(btn1,"rotation",0,-90),
                        ObjectAnimator.ofFloat(btn1,"translationX",0,90),
                        ObjectAnimator.ofFloat(btn1,"translationY",0,90),
                        ObjectAnimator.ofFloat(btn1,"scaleX",1,1.5f),
                        ObjectAnimator.ofFloat(btn1,"scaleY",1,1.5f),
                        ObjectAnimator.ofFloat(btn1,"alpha",0.25f,1));
                set.setDuration(5*1000).start();
            }
        });

//        Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim1);
//        btn1.startAnimation(animation);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        alphaAnimation.setDuration(500);
//        btn1.startAnimation(alphaAnimation);
    }
}
