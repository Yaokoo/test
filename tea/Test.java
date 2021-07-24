package co.stu.tea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        HashMap teasMap=new HashMap();         //存放老师信息的map集合
        Tea t1=new Tea();
        t1.setName("A老师");
        t1.setNo(1);
        teasMap.put(t1.getName(),t1);
        Tea t2=new Tea();
        t2.setName("B老师");
        t2.setNo(2);
        teasMap.put(t2.getName(),t2);



        HashMap stusMap=new HashMap();
        Stu s1=new Stu();
        s1.setName("A同学");
        s1.setNo(1);
        stusMap.put(s1.getName(),s1);
        Stu s2=new Stu();
        s2.setName("B同学");
        s2.setNo(2);
        stusMap.put(s2.getName(),s2);



        HashMap cosMap=new HashMap();
        Co c1=new Co();
        c1.setName("语文");
        c1.setNo(1);
        cosMap.put(c1.getName(),c1);
        Co c2=new Co();
        c2.setName("数学");
        c2.setNo(2);
        cosMap.put(c2.getName(),c2);

        t1.getStus().add(s1);
        t1.getStus().add(s2);
        s1.getTeas().add(t1);
        s2.getTeas().add(t1);

        t2.getStus().add(s2);
        s2.getTeas().add(t2);

        c1.getStus().add(s1);
        c1.getTeas().add(s2);
        s1.getCos().add(c1);
        s2.getCos().add(c1);

        c2.getStus().add(s1);
        c2.getStus().add(s2);
        s1.getCos().add(c1);
        s2.getCos().add(c2);

        t1.setCo(c1);
        c1.getTeas().add(t1);
        t2.setCo(c2);
        c2.getTeas().add(t2);

        Scanner sc=new Scanner(System.in);
        while (true){
            String str=sc.next();
            Tea t=(Tea)teasMap.get(str);
            Stu s=(Stu)stusMap.get(str);
            Co c=(Co)cosMap.get(str);

            if(t!=null) {
                ArrayList stus = t.getStus();
                Iterator<Stu> it = stus.iterator();
                while (it.hasNext()) {
                    Stu ss = it.next();
                    System.out.println(ss.getName() + "\t" + ss.getNo());
                }
            }
                if(s!=null){
                    ArrayList teas=s.getTeas();
                    for(Object o:teas){
                        Tea tt=(Tea)o;
                        System.out.println(tt.getName()+"\t"+tt.getNo());
                    }
                }
                if(c!=null){
                    ArrayList teas=c.getTeas();
                    ArrayList stus=c.getStus();
                    for(Object o:teas){
                        Tea tt=(Tea)o;
                        System.out.println(tt.getName()+"\t"+tt.getNo());
                    }
                    for(Object o:stus){
                        Stu ss=((Stu)o);
                        System.out.println(ss.getName() + "\t" + ss.getNo());
                    }
                }
            }
        }
}
