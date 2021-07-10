package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*1.文件字节输入流 万能 任何类型的文件都可以通过这个来读
      2.字节的方式 完成输入操作 读（硬盘--->内存）

    */
public class FileInputStreamTest01 {
    //创建文件字节流输入对象
    //文件路径 D：/jiu.txt
    public static void main(String[] args) {
        FileInputStream fis=null;

        {
            try {
                fis = new FileInputStream("D:/temp.txt");
                byte[] bb=new byte[fis.available()];
                fis.read(bb);
                System.out.println(new String(bb));
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
}
