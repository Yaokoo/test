package Thread;
//匿名内部类
public class ThreadTest03 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("分支线程--"+i);
                }
            }
        });
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程--"+i);
        }
    }
}
