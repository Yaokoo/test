package co.stu.tea;

import java.util.ArrayList;

    class Co {
    private String name;
    private int no;
    private ArrayList teas=new ArrayList();
    private ArrayList stus=new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ArrayList getTeas() {
        return teas;
    }

    public void setTeas(ArrayList teas) {
        this.teas = teas;
    }

    public ArrayList getStus() {
        return stus;
    }

    public void setStus(ArrayList stus) {
        this.stus = stus;
    }
}
