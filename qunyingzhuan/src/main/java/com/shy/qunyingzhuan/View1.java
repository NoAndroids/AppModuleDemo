package com.shy.qunyingzhuan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

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
 * Created by ShangHongYu on 2017/11/2.
 */

public class View1 extends View {
    private String TAG="shy";
    public View1(Context context) {
        super(context);
    }
    private int minWidth=200;
    private int minHeight=100;
    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //用于测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureWidth(widthMeasureSpec),MeasureHeight(heightMeasureSpec));
    }
//    Canvas mCanvas=new Canvas();
    Bitmap bitmap1=BitmapFactory.decodeResource(this.getResources(),R.mipmap.ic_launcher);
    Bitmap bitmap2=BitmapFactory.decodeResource(this.getResources(),R.mipmap.ic_launcher).copy(Bitmap.Config.ARGB_8888,true);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap1,0,0,null);
        canvas.drawBitmap(bitmap2,100,0,null);
        Canvas mCanvas=new Canvas(bitmap2);
        mCanvas.drawRGB(33,3,35);
    }

    private int MeasureWidth(int widthMeasureSpec){
        int result =0;
        int specMode=MeasureSpec.getMode(widthMeasureSpec);
        int specSize=MeasureSpec.getSize(widthMeasureSpec);
        switch (specMode){
            case MeasureSpec.EXACTLY:
                result=specSize;
                break;
            case MeasureSpec.AT_MOST:
                result=Math.min(specSize,minWidth);
                break;
        }
        Log.i(TAG, "MeasureWidth: "+result);
        return  result;
    }
    private int MeasureHeight(int heightMeasureSpec){
        int result =0;
        int specMode=MeasureSpec.getMode(heightMeasureSpec);
        int specSize=MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode){
            case MeasureSpec.EXACTLY:
                result=specSize;
                break;
            case MeasureSpec.AT_MOST:
                result=Math.min(specSize,minHeight);
                break;
        }
        Log.i(TAG, "MeasureHeight: "+result);
        return  result;
    }

    //自定义控件比较重要的回调方法
//    从XML加载组件的回调
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
    //组件大小改变时回调
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
    //用于确定显示的位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    //监听触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
