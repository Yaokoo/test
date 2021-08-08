package com.createthread.p1;
/*
    start 调用 不代表线程开始运行
    多线程结果与代码顺序无关

 */
public class Test {
    public static void main(String[] args) {
        System.out.println("主线程打印1");
        MyThread t1=new MyThread();
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程打印2");
    }
}
