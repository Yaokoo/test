public class Test01 {
    private int flag=0;

    public synchronized void soutA(){
        for (int i = 0; i < 5; i++) {
            while (flag!=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("a");
            flag=1;
            notifyAll();
        }
    }

    public synchronized void soutB(){
        for (int i = 0; i < 5; i++) {
            while (flag!=1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("b");
            flag=2;
            notifyAll();
        }
    }

    public  synchronized void soutC(){
        for (int i = 0; i < 5; i++) {
            while (flag!=2){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c");
            flag=3;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test01 test01=new Test01();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                test01.soutA();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        });
        Test01 test02=new Test01();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                test01.soutB();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        });
        Test01 test03=new Test01();
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                test01.soutC();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        });
    }
}
