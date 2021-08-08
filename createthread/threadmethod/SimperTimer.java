package com.createthread.threadmethod;

public class SimperTimer {
    public static void main(String[] args) {
        int time=10;
        if(args.length==1){
            time=Integer.parseInt(args[0]);
        }
        while (true){
            System.out.println("time:"+time);
            time--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time<0){
                break;
            }
        }
        System.out.println("WOOOOW");
    }
}
