package com.createthread.p3;

import com.createthread.p1.MyThread;

public class Test {
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread t1=new Thread(runnable);
        t1.start();
        try {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName()+"xxxxxxxxx");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyRunnable myRunnable=new MyRunnable();
        Thread t2=new Thread(myRunnable);
        t2.start();
    }
}
