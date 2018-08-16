package com.shy.javatest.fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jdk.nashorn.internal.objects.annotations.Constructor;

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
 * Created by ShangHongYu on 2018/7/5.
 */

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class c=C1.class;
//        try {
//            Class c1=Class.forName("com.shy.javatest.fanshe.C1");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Class c2=new C1().getClass();
        Class<?> c1clazz = Class.forName("com.shy.javatest.fanshe.C1");
//        java.lang.reflect.Constructor<?> constructor=c1clazz.getConstructor(String.class);
//        Object o=constructor.newInstance("00111");
//        System.out.print( o.getClass().getName());
        Object o = c1clazz.newInstance();
        System.out.print(o.getClass().getName());
        Method  method=c1clazz.getDeclaredMethod("setb",String.class);
        method.setAccessible(true);
        method.invoke(o,"abc");
        System.out.print(o.toString());

    }
}
