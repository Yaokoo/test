package com.createthread.threadmethod;

public class SubThread5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.isInterrupted()){
                System.out.println("退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        SubThread5 subThread5=new SubThread5();
        subThread5.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        subThread5.interrupt();
    }
}
