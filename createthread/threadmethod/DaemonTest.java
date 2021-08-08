package com.createthread.threadmethod;

public class DaemonTest extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("xxxxxx");
        }
    }

    public static void main(String[] args) {
        DaemonTest t1=new DaemonTest();
        t1.setDaemon(true);
        t1.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("mmmmmmmm");
        }
    }
}
