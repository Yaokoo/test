package com.nio.netNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * @author yaokoo
 * @create 2021/8/17 22:03
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //客户端
        //通道
        SocketChannel sChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9000));
        //非阻塞
        sChannel.configureBlocking(false);
        //写
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put(new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        //关
        sChannel.close();
    }
}
