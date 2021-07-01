package Thread;

public class ThreadTest05 {
    public static void main(String[] args) {
       /* try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("helloworld");*/
        for (int i = 0; i < 10; i++) {
            Thread currentThread=Thread.currentThread();
            System.out.println(currentThread.getName()+"-->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
