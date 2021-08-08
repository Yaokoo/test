package com.createthread.p1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("子线程");
    }
}
