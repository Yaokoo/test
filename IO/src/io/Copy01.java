package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy01 {
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream("D:\\Java！\\更新日志.txt");
            fos=new FileOutputStream("D:/更新日志.txt");
            byte[] bytes=new byte[1024*1024];
            int readCount=0;
            while((readCount= fis.read(bytes))!=-1){
                fos.write(bytes,0,readCount);
            }
            fos.flush();
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
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
