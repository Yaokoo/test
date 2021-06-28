package nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;  

public class Client {
    private Selector selector;
    private static final int PORT=9999;
    private SocketChannel socketChannel;

    public Client(){
        try {
            selector=Selector.open();
            socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("当前客户端准备完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client client=new Client();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.readInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            client.sendToServer(s);
        }
    }

    private void sendToServer(String s) {
        try {
            socketChannel.write(ByteBuffer.wrap((":"+s).getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readInfo() throws IOException {
        while (selector.select()>0){
            Iterator<SelectionKey> iterator=selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key=iterator.next();
                if (key.isReadable()){
                    SocketChannel sc= (SocketChannel) key.channel();
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    System.out.println(new String(buffer.array()));
                }
                iterator.remove();
            }
        }
    }
}
