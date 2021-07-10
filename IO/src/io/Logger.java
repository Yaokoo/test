package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//日志工具
public class Logger {
    public static void Log(String msg){
        try {
            PrintStream printStream=new PrintStream(new FileOutputStream("log",true));
            System.setOut(printStream);
            Date nowTime=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime=sdf.format(nowTime);
            System.out.println(strTime+":"+msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
