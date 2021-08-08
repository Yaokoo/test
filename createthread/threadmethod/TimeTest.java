package com.createthread.threadmethod;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        String date="今天是2018年08月07日";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("今天是y年M月d日");
        try {
            Date date1=simpleDateFormat.parse(String.valueOf(date));
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
