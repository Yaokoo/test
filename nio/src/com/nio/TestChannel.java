package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yaokoo
 * @create 2021/8/15 22:48
 */
public class TestChannel { //1471095500
    public static void main(String[] args) {
        long start=System.nanoTime();
        //先建立流
        FileInputStream in=null;
        FileOutputStream out=null;
        FileChannel inchannel=null;
        FileChannel outchannel=null;

        try {
             in=new FileInputStream("D://图片//轰辉.mp4");
            out=new FileOutputStream("D://图片//轰辉11.mp4");


            //通过流获取通道
            inchannel=in.getChannel();
            outchannel=out.getChannel();

            //非直接缓冲区进行读写
            ByteBuffer buf=ByteBuffer.allocate(1024);
            while (inchannel.read(buf)!=-1){
                buf.flip();
                outchannel.write(buf);
                buf.clear();
            }

            long end=System.nanoTime();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (outchannel != null) {
                try {
                    outchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (inchannel!=null){
                try {
                    inchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if ( out!= null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
