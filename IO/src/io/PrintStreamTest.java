package io;

import java.io.FileOutputStream;
import java.io.PrintStream;

//默认输出控制台 不需要手动关闭
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        PrintStream printStream=new PrintStream(new FileOutputStream("log"));
        System.setOut(printStream);
        System.out.println("hello world");
    }
}
