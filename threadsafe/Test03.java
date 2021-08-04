package com.threadsafe;

import java.util.concurrent.CountDownLatch;

/**
 * @author yaokoo
 * @create 2021/7/30 18:52
 */
public class Test03 {

    private static class T{
     private long a,b,c,d,e,f,g;
        private long l=0L;
      private long a1,b2,c2,d2,e2,f2,g2;
    }

    public  static T[] arr=new T[2];


    static {
        arr[0]=new T();
        arr[1]=new T();
    }

    public static void main(String[] args) {
        CountDownLatch count=new CountDownLatch(2);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    arr[0].l=i;
                }
                count.countDown();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    arr[1].l=i;
                }
                count.countDown();
            }
        });

        final long start=System.nanoTime();
        t1.start();
        t2.start();
        System.out.println((System.nanoTime()-start)/1000);
    }
}