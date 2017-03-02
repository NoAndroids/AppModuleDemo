package com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.dagger;

import android.content.Context;
import android.widget.AutoCompleteTextView;

import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.Bean.News;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.NetWork.NewsApiService;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.NewslvAdapter;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view.MainActivity;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view.MainView;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view.presenter.MainPresenter;

import java.util.List;

import dagger.Module;
import dagger.Provides;

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
 * Created by ShangHongYu on 2017/3/1.
 */
@Module
public class MainActivityModule {
    private MainView mainView;
    private Context context;
    private MainActivity mainActivity;
    public MainActivityModule(Context context) {
        this.mainView = (MainView) context;
        this.context=context;
    }
    @Provides
    MainView provideMainView(){
        return mainView;
    }
    @Provides
    Context provideMainActivity(){
        return context;
    }
    @Provides
    List<News.NewslistBean> provideNewslistBean(){
        return  new  News().getNewslist();
    }
    @Provides
    NewslvAdapter provideNewslvAdapter(Context context, List<News.NewslistBean> data){
        return  new NewslvAdapter(context,data);
    }
    @Provides
    MainPresenter providesMainPresenter(MainView mainView, NewsApiService newsApiService){
        return new MainPresenter(mainView,newsApiService);
    }
}
