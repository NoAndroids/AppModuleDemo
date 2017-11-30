package com.shy.qunyingzhuan;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
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
 * Created by ShangHongYu on 2017/11/7.
 */

public class Topbar extends RelativeLayout {

    public Topbar(Context context) {
        this(context,null);
    }

    public Topbar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    private String mTilte;
    private float mTitleSize;
    private int mTitleColor;
    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTextView;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;
    private topbarClickListener topbarClickListener;
    public Topbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取在attrs 中的属性 存储到 typedarray中
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        mTilte=typedArray.getString(R.styleable.TopBar_title);
        mTitleSize=typedArray.getDimension(R.styleable.TopBar_titleTextSize,24);
        mTitleColor=typedArray.getColor(R.styleable.TopBar_titleTextColor,0);
        mLeftBackground=typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText=typedArray.getString(R.styleable.TopBar_leftText);
        mLeftTextColor=typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        mRightBackground=typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText=typedArray.getString(R.styleable.TopBar_rightText);
        mRightTextColor=typedArray.getColor(R.styleable.TopBar_rightTextColor,0);
        //避免重新创建的时候的错误
        typedArray.recycle();
        mLeftButton=new Button(context);
        mRightButton=new Button(context);
        mTextView=new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        mTextView.setText(mTilte);
        mTextView.setTextColor(mTitleColor);
        mTextView.setTextSize(mTitleSize);
        mTextView.setGravity(Gravity.CENTER);

        //为组件元素设置相应的布局元素
        mLeftParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        //添加到viewgroup
        addView(mLeftButton,mLeftParams);

        mRightParams=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightParams);

        mTitleParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTextView,mTitleParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topbarClickListener.leftClick();
            }
        });
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topbarClickListener.rightClick();
            }
        });
    }
    public void setTopbarClickListener(topbarClickListener topbarClickListener){
        this.topbarClickListener=topbarClickListener;
    }
    public interface topbarClickListener{
        void leftClick();
        void rightClick();
    }
}
