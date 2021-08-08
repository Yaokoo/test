package com.createthread.threadmethod;

public class SubThread1 extends Thread {
    public SubThread1(){
        System.out.println("当前线程"+Thread.currentThread().getName());
        System.out.println("当前调用对象"+this.getName());
    }

    @Override
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getName());
        System.out.println("当前调用对象"+this.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        SubThread1 t1=new SubThread1();
        t1.setName("t1");
        t1.start();
        Thread.sleep(500);
        t1.run();;
        Thread t2=new Thread(t1);
        t2.start();
    }
}
