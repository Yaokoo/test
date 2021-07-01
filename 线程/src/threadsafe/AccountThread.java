package threadsafe;

public class AccountThread extends Thread{
    private Account act;
    public AccountThread(Account act){
        this.act=act;
    }
    public void run(){
        //run执行的取款操作
        double money=5000;
        act.withdrow(money);
    }
}
