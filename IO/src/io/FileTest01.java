package io;
/*
File
1.File不能完成文件的读写
2.代表文件和路径名的抽象表示形式（有可能是目录 有可能是文件
3.掌握常用的方法
 */

import java.io.File;

public class FileTest01 {
    public static void main(String[] args) {
        File f1=new File("D:\\Javaproject\\myfile");
        File parentFile=f1.getParentFile();
        System.out.println(parentFile.getAbsolutePath());
        /*File f1=new File("file");
        File f2=new File("a/b/c/d/e");//多重目录  mkdirs
        System.out.println(f1.exists());
        if(!f1.exists()){
            f1.mkdir();//创建目录
        }*/
    }
}
