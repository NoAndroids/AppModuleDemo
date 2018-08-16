package com.shy.javatest;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by ShangHongyu on 2018/7/11.
 */

public class VolatileTest {
    public volatile  int inc=0;
    public void increase(){
        inc++;
    }
    public static void main(String[] args){
        final VolatileTest volatileTest=new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int j=0;j<1000;j++){
                        volatileTest.increase();
                    }

                }
            }.start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(volatileTest.inc);
    }
}
