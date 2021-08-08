package com.createthread.p4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws Exception {
        MyCallable myCallable=new MyCallable();
        FutureTask task=new FutureTask(myCallable);
        Thread thread=new Thread(task);
        thread.start();
        System.out.println(task.get());  //task.get 会导致当前线程阻塞
        System.out.println("xxx");

    }
}
