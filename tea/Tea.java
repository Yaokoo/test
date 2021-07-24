package co.stu.tea;

import java.util.ArrayList;

    class Tea {
    private String name;
    private int no;
    private ArrayList stus=new ArrayList();
    private Co co;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getNo(){
        return no;
    }

    public void setNo(int no){
        this.no=no;
    }

    public ArrayList getStus(){
        return stus;
    }

    public void setStus(ArrayList stus){
        this.stus=stus;
    }

    public Co getCo(){
        return co;
    }

    public void setCo(Co co){
        this.co=co;
    }
}
