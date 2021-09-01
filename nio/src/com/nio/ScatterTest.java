package com.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yaokoo
 * @create 2021/8/17 18:42
 */
public class ScatterTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile=new RandomAccessFile("D://jiu.txt","rw");
        //获取通道
        FileChannel channel =accessFile.getChannel();

        ByteBuffer buf1=ByteBuffer.allocate(10);
        ByteBuffer buf2=ByteBuffer.allocate(1024);
        //分散读取（读到一个集合里）
        ByteBuffer[] buffers={buf1,buf2};

        channel.read(buffers);

        for(ByteBuffer b:buffers){
            b.flip();
        }
        System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));

    }
}
