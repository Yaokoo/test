package com.threadsafe;

/**
 * @author yaokoo
 * @create 2021/7/30 0:12
 */
public class Test01 {
    public static void main(String[] args) {
        MyInt myInt=new MyInt();
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+"--->"+myInt.show());
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

class MyInt{
    int a;
    public int show(){
       return a++;
    }
}
