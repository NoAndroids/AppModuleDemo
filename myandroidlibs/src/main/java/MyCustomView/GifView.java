package MyCustomView;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

import com.shy.myandroidlibs.R;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/17.
 */
public class GifView extends View {
    /*
    * Movie 类
    *
    * */
    private Resources resources;
    private Movie movie;
    private long movieStart;

    public GifView(Context context) {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GifView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(R.styleable.GifView);
        resources = context.getResources();
        int resourceid = array.getResourceId(R.styleable.GifView_src, -1);
        setGifResource(resourceid);
    }

    public void setGifResource(int resourceid) {
        if (resourceid == -1) {
            return;
        }
        InputStream is = resources.openRawResource(resourceid);
        movie = Movie.decodeStream(is);
        requestLayout();
    }

    public void setGifStream(InputStream is) {
        movie = Movie.decodeStream(is);
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long now = android.os.SystemClock.uptimeMillis();//当前时间


        if (movieStart == 0) {//第一次
            movieStart = now;
        }
        if (movie != null) {
            int dur = movie.duration();//获取总时长
            if (dur == 0) {
                dur = 1000;//毫秒
            }
            int relTime=(int )((now-movieStart)%dur);//获取当前需要显示哪一部分时间的图像
            movie.setTime(relTime);
            movie.draw(canvas,getWidth()-movie.width(),getHeight()-movie.height());
            invalidate();
        }
    }
}
