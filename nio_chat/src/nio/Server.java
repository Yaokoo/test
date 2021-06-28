package nio;

import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

public class Server {
    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int PORT=9999;

    //2.初始化代码逻辑
    public Server(){
        try {
            //选择器
            selector=Selector.open();
            //通道
            ssChannel=ServerSocketChannel.open();
            //绑定端口
            ssChannel.bind(new InetSocketAddress(PORT));
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server=new Server();
        server.listen();
    }
        //监听
    private void listen(){
        try {
            while (selector.select()>0){
                Iterator<SelectionKey> it=selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey sk=it.next();
                    if (sk.isAcceptable()){
                        SocketChannel sChannel =ssChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector,SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        readClientData(sk);
                    }it.remove();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readClientData(SelectionKey sk) {
        SocketChannel sChannel=null;
        try{
            sChannel= (SocketChannel) sk.channel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            int count=sChannel.read(buffer);
            if(count>0){
                buffer.flip();
                String msg=new String(buffer.array());
                System.out.println("接收到客户端消息："+msg);
                sendMsgToAllClient(msg,sChannel);
            }
        }catch (Exception e){
           try{
               System.out.println("有人下线了"+sChannel.getRemoteAddress());
               sk.cancel();
               sChannel.close();
           }catch (Exception e1){
                e1.printStackTrace();
           }
        }
    }

    private void sendMsgToAllClient(String msg, SocketChannel sChannel) throws IOException {
        System.out.println("服务端开始转发这个消息：当前处理的线程："+Thread.currentThread().getName());
        for (SelectionKey key:selector.keys()){
            Channel channel=  key.channel();
            if (channel instanceof SocketChannel && channel!=sChannel){
                ByteBuffer buffer=ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel)channel).write(buffer);
            }
        }
    }
}
