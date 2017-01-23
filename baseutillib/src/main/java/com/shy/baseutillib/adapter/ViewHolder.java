package com.shy.baseutillib.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Created by ShangHongYu on 2017/1/13.
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context mContext;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position)
    {
        mContext = context;
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,false);
        mConvertView.setTag(this);   // setTag
    }
    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView,ViewGroup parent, int layoutId, int position)
    {
        if (convertView == null){
            //创建ViewHolder对象 ,并做View缓存
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder)convertView.getTag();
    }
    public View getConvertView()
    {
        return mConvertView;
    }
    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId){

        View view = mViews.get(viewId);
        if (view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T)view;
    }
    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setEditText(int viewId, String text)
    {
        EditText view = getView(viewId);
        view.setText(text);
        return this;
    }
    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text)
    {
        TextView view = getView(viewId);
        if (view != null) {
            view.setText(text);
        }
        return this;
    }
    public ViewHolder setText(int viewId, @StringRes int strId)
    {
        TextView view = getView(viewId);
        view.setText(strId);
        return this;
    }
    public ViewHolder setTextDrawLeft(int viewId,Drawable drawable){
        TextView view = getView(viewId);
        view.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        return this;
    }
    public ViewHolder setTextDrawRight(int viewId,Drawable drawable){
        TextView view = getView(viewId);
        view.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        return this;
    }
    public ViewHolder setTextColor(int textViewId, @ColorInt int color) {
        TextView view = getView(textViewId);
        view.setTextColor(color);
        return this;
    }
    /**
     * 为ImageView设置图片
     *  setImageResource
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId,@DrawableRes int drawableId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }
    public ViewHolder setTextViewBackgroundColor(int viewId, int color) {
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setBackgroundColor(color);
        }
        return this;
    }
    public ViewHolder setViewBackgroundColor(int viewId, int color) {
        View textView = getView(viewId);
        if (textView != null) {
            textView.setBackgroundColor(color);
        }
        return this;
    }
    /**
     * 为ImageView设置图片
     *  setImageBitmap
     * @param viewId
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }
    /**
     * 设置view的可见性
     * @param viewId
     * @param visibility
     */
    public void setViewVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        if (view != null) {
            view.setVisibility(visibility);
        }
    }
    /**
     * 为view设置监听事件
     * @param viewId
     * @param listener
     */
    public void setViewClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }
    public int getPosition(){

        return mPosition;
    }
    /**
     * 设置view的背景颜色
     * @param viewId
     * @param colorId
     */
    public void setViewBackground(int viewId, int colorId) {
        View view = getView(viewId);
        if (view != null) {
            view.setBackgroundColor(mContext.getResources().getColor(colorId));
        }
    }
}
