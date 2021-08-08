package com.createthread.p2;

public class Test {
    public static void main(String[] args) {
        MyThread2 t1=new MyThread2();
        t1.start();
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
