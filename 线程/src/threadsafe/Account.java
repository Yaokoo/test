package threadsafe;

public class Account {

    private String actno;
    private double balance;

    public Account() {
    }

    public Account(String actno, int balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款方法
    public void withdrow(double money){
        //之前
        double before=this.balance;
        //之后
        double after=before-money;
        //更新
        this.setBalance(money);
    }
}
