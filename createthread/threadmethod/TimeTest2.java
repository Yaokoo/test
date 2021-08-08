package com.createthread.threadmethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest2 {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat sdf=new SimpleDateFormat("现在是yy年MM月dd日HH时mm分S秒");
        System.out.println(sdf.format(date));
    }
}
