package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fis=null;
        try {
            fis=new FileInputStream("D:/temp.txt");
            System.out.println("起始字节数量："+fis.available());
            //int readDate=fis.read();
            byte[] bytes=new byte[fis.available()];
            fis.read(bytes);
            System.out.println(new String(bytes));
            System.out.println("还能读的字节数:"+fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
