package Thread;

public class ThreadTest06 {
    public static void main(String[] args) {
        System.out.println("最高优先级"+Thread.MAX_PRIORITY);
        System.out.println("最低优先级"+Thread.MIN_PRIORITY);
        System.out.println("默认优先级"+Thread.NORM_PRIORITY);
        //Thread currenThread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"默认优先级"+Thread.currentThread().getPriority());
        Thread t=new Thread(new MyRunnable1());
        t.setName("t");
        t.start();
    }
}

class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"默认优先级"+Thread.currentThread().getPriority());
    }
}
