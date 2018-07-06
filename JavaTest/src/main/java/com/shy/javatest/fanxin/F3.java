package com.shy.javatest.fanxin;

import java.util.ArrayList;
import java.util.List;

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
 * Created by ShangHongYu on 2018/7/4.
 */

public class F3 {
    private void test(List<?> c){
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i)+"===="+c.get(i).getClass());
        }
    }
    public static void main(String[] arg){
        F3 f3=new F3();
        List<String> strlist=new ArrayList<>();
        strlist.add("a1");
        strlist.add("a2");
        strlist.add("a3");
        strlist.add("a4");
        f3.test(strlist);
        System.out.println("-------------");
        List<Integer> intlist=new ArrayList<>();
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);
        f3.test(intlist);
        System.out.println("-------------");
        List<F1> f1list=new ArrayList<>();
        f1list.add(new F1(1));
        f1list.add(new F1("2"));
        f1list.add(new F1(3));
        f1list.add(new F1(new F2(2)));
        f3.test(f1list);
        ////////////////
        List<?> c=new ArrayList<>();
//        c.add("123");
    }
}
