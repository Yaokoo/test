package Thread;

public class ThreadTest07 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable2());
        t.setName("t");
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            if (i%100==0){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}
