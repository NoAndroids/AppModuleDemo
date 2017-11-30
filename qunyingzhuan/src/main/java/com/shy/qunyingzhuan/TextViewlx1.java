package com.shy.qunyingzhuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * Created by ShangHongYu on 2017/11/6.
 */

public class TextViewlx1 extends android.support.v7.widget.AppCompatTextView {
    private Paint mPaint1;
    private Paint mPaint2;
    public TextViewlx1(Context context) {
        this(context,null);
    }

    public TextViewlx1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextViewlx1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint1=new Paint();
        mPaint1.setColor(getResources().getColor(R.color.colorAccent));
        mPaint1.setStyle(Paint.Style.FILL);//填充
//        mPaint1.setStyle(Paint.Style.STROKE);//不填充
        mPaint2=new Paint();
        mPaint2.setColor(getResources().getColor(R.color.colorPrimary));
        mPaint2.setStyle(Paint.Style.FILL);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        //在回调父类方法前，实现自己的逻辑，对textview来说即在绘制文本内容前
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1); //绘制内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();
        canvas.translate(10,0);//绘制文字前平移10像素
        super.onDraw(canvas);
        //在回调父类方法后，实现自己的逻辑，对textview来说即在绘制文本内容后
        canvas.restore();
    }
}
