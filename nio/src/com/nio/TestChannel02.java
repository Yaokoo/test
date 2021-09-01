package com.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author yaokoo
 * @create 2021/8/17 13:42
 */
public class TestChannel02 {
    public static void main(String[] args) {//297515000
        long start=System.nanoTime();
        FileChannel in;
        FileChannel out;
        {
            try {
                //获取通道
                in = FileChannel.open(Paths.get("D://图片//轰辉.mp4"), StandardOpenOption.READ);
                out = FileChannel.open(Paths.get("D://图片//轰辉11.mp4"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

                //建立直接内存
                MappedByteBuffer inbuf =in.map(FileChannel.MapMode.READ_ONLY,0, in.size());
                MappedByteBuffer outbuf =out.map(FileChannel.MapMode.READ_WRITE,0, in.size());

                //将数据放到直接缓存中
                byte[] bytes=new byte[inbuf.limit()];
                inbuf.get(bytes);
                outbuf.put(bytes);
                in.close();
                out.close();
                long end=System.nanoTime();
                System.out.println(end-start);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
