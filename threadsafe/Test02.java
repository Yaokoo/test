package com.threadsafe;

/**
 * @author yaokoo
 * @create 2021/7/30 18:25
 */
public class Test02 {
    private static volatile boolean flag=true;

    private static void m(){
        System.out.println("开始执行");
        while (flag){
           /* System.out.println("hello");*/
        }
        System.out.println("结束");
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test02.m();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Test02.flag=false;
    }
}
