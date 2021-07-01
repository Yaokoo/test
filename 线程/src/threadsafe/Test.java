package threadsafe;

public class Test {
    public static void main(String[] args) {
        Account act=new Account("001",10000);
        Thread t1=new AccountThread(act);
        Thread t2=new AccountThread(act);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
