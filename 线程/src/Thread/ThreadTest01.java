package Thread;

public class ThreadTest01 {
    //堆和方法区空间共享
    //栈空间独立 空间不共享
    //实现线程的第一种方式 编写类继承Thread 重新run
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();//开辟新的栈空间
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程-->"+i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程分支--->"+i);
        }
    }
}
