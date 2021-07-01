package Thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        Thread currentThread=Thread.currentThread();
        System.out.println(currentThread.getName());
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread currentThread=Thread.currentThread();
                    System.out.println(currentThread.getName()+"--"+i);
                }
            }
        });
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+i);
        }
    }
}

