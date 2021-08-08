package com.createthread.threadmethod;

public class SubThread3 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"开始执行时间"+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("线程"+Thread.currentThread().getName()+"结束执行时间"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("线程"+Thread.currentThread().getName()+"开始执行时间"+System.currentTimeMillis());
        SubThread3 subThread3=new SubThread3();
        subThread3.start();
        System.out.println("线程"+Thread.currentThread().getName()+"结束执行时间"+System.currentTimeMillis());
    }
}
