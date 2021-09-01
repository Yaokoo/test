package com.nio;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author yaokoo
 * @create 2021/8/17 18:28
 */
public class TestChannel03 {
    public static void main(String[] args) throws Exception {
        FileChannel in=FileChannel.open(Paths.get("D://jiu.txt"), StandardOpenOption.READ);
        FileChannel out=FileChannel.open(Paths.get("D://jiucopy.txt"),StandardOpenOption.READ,
                StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);

        in.transferTo(0,in.size(),out);

        in.close();
        out.close();
    }
}
