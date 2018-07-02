package com.shy.javatest;

public class myClass extends Thread {
    @Override
    public void run() {
        System.out.print("thread test");
    }

    public static void main(String[] args){
        myClass testThread=new myClass();
        testThread.start();
    }
}
