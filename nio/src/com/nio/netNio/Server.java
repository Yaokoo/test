package com.nio.netNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author yaokoo
 * @create 2021/8/17 22:16
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //开
        ServerSocketChannel ssChannel=ServerSocketChannel.open();
        //非
        ssChannel.configureBlocking(false);
        //绑
        ssChannel.bind(new InetSocketAddress(9000));
        //选
        Selector selector=Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询选择器
        while (selector.select()>0){
            Iterator it =selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk= (SelectionKey) it.next();
                if (sk.isAcceptable()){
                    SocketChannel schannel =ssChannel.accept();
                    schannel.configureBlocking(false);
                    schannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    SocketChannel rChannel= (SocketChannel) sk.channel();
                    ByteBuffer buf=ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=rChannel.read(buf))!=-1){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                it.remove();
            }
        }
    }
}
