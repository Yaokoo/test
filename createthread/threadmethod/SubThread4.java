package com.createthread.threadmethod;

public class SubThread4 extends Thread{
    @Override
    public void run() {
        System.out.println("name"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SubThread4().start();
        }
    }
}
