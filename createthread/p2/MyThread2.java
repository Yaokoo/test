package com.createthread.p2;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName()+" "+i);
                int time=(int)(Math.random()*1000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
