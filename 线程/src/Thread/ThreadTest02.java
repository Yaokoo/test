package Thread;
//2.编写类实现接口 然后newThread 对象
public class ThreadTest02 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
        Thread t1=new Thread(new MyRunnable());
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(">>"+i);
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread currentThread=Thread.currentThread();
            System.out.println(currentThread.getName()+"--->"+i);
        }
    }
}
