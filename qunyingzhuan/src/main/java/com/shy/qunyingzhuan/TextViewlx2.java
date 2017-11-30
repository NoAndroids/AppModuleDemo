package com.shy.qunyingzhuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
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

public class TextViewlx2 extends android.support.v7.widget.AppCompatTextView {
    private String TAG="shy";
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private int mViewWidth=0;
    public TextViewlx2(Context context) {
        this(context,null);
    }

    public TextViewlx2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextViewlx2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        Log.i(TAG, "onSizeChanged: ");
        if (mViewWidth==0){
            mViewWidth=getMeasuredWidth();
            if (mViewWidth>0){
                mPaint=getPaint();//获取当前绘制textview 的paint
                mLinearGradient=new LinearGradient(0,0,mViewWidth,0,
                        new int[]{Color.BLUE,0xffffffff,Color.BLUE},
                        null, Shader.TileMode.CLAMP);
            }
            mPaint.setShader(mLinearGradient);
            mMatrix=new Matrix();
        }
    }
    private float mTranslate=0;
    @Override
    protected void onDraw(Canvas canvas) {
//        Log.i(TAG, "onDraw: ");
        super.onDraw(canvas);
        if (mMatrix!=null){
            mTranslate+=mViewWidth/5;
            if (mTranslate>2*mViewWidth){
                mTranslate=-mViewWidth;
            }
            mMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }
    }
}
