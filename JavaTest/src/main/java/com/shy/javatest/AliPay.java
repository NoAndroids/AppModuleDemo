package com.shy.javatest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
 * Created by ShangHongYu on 2018/6/27.
 */

public class AliPay {
    private double[] accounts;//账户数量
    private Lock alipayLock;
    private Condition condition;
    public AliPay(int n , double  money) {
        accounts=new double[n];
        alipayLock=new ReentrantLock();
        condition=alipayLock.newCondition();
        for (int i = 0; i < accounts.length; i++) {
            accounts[i]=money;
        }
    }
    public  void transfer(int from,int to ,int amount) throws InterruptedException {
        alipayLock.lock();
        try {
            while (accounts[from]<amount){
                //
                condition.await();//阻塞当前线程，并放弃锁
            }
            accounts[from]=accounts[from]-amount;
            accounts[to]=accounts[to]+amount;
            condition.signalAll();
        }finally {
            alipayLock.unlock();
        }
    }
}
