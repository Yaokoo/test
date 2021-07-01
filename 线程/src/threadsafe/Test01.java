package threadsafe;

public class Test01 {
    public static void main(String[] args) {
       Thread m1=new Thread(new MyThread1());
       Thread m2=new Thread(new MyThread1());
       m1.start();
       m2.start();
    }
}
class MyThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}