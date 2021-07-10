package niodemo;

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
        //1.获取通道
            System.out.println("服务端启动----------");
            ServerSocketChannel ssChannel=ServerSocketChannel.open();
            //2.切换为非阻塞模式
            ssChannel.configureBlocking(false);
            //3.建立连接   绑定端口
            ssChannel.bind(new InetSocketAddress(9999));
            //4.获取选择器selector
            Selector selector=Selector.open();
            //5.将通道注册到选择器上
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            //6.轮询
            while (selector.select()>0){
                Iterator<SelectionKey> it=selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey sk= it.next();
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
                            System.out.println(new String(buffer.array()));
                            buffer.clear();
                        }
                    }
                    it.remove();
                }
            }
        }
    }

