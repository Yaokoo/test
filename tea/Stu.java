package co.stu.tea;

import java.util.ArrayList;

    class Stu {
    private String name;
    private int no;
    private ArrayList teas=new ArrayList();
    private ArrayList cos=new ArrayList();

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

    public ArrayList getCos() {
        return cos;
    }

    public void setCos(ArrayList cos) {
        this.cos = cos;
    }
}
