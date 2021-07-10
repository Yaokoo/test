package io.niodemo1;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssChannel=ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.bind(new InetSocketAddress(9999));
        Selector selector=Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select()>0){
            Iterator<SelectionKey> it =selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk=it.next();
                if(sk.isAcceptable()){
                    SocketChannel schannel=ssChannel.accept();
                    schannel.configureBlocking(false);
                    schannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    SocketChannel sChannel= (SocketChannel) sk.channel();
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=sChannel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(buffer.array().toString());
                        buffer.clear();
                    }
                }
                it.remove();
            }
        }
    }
}
