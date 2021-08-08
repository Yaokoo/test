package com.createthread.threadmethod;

public class SubThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("线程是否存活"+this.isAlive());
    }

    public static void main(String[] args) {
        SubThread2 subThread2=new SubThread2();
        System.out.println("开始前线程是否存活"+subThread2.isAlive());
        subThread2.start();
        System.out.println("开始后线程是否存活"+subThread2.isAlive());
    }
}
