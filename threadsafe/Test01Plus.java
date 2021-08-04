package com.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yaokoo
 * @create 2021/7/30 0:36
 */
public class Test01Plus {
    public static void main(String[] args) {
        MyIntDemo myIntDemo=new MyIntDemo();
        for (int i=0;i<2;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName()+"--->"+myIntDemo.show());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}

class MyIntDemo{
    AtomicInteger a=new AtomicInteger(0);
    public int show(){
        return a.getAndIncrement();//getAndIncrement返回的是当前值； incrementAndGet返回的是加1后的值。 c

    }
}
