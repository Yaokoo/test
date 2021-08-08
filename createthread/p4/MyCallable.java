package com.createthread.p4;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(500);
        }
        int a=95;
        int b=2;
        return a+b;
    }
}
