package niodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        SocketChannel sChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
        sChannel.configureBlocking(false);
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.print("请说:");
            String msg=sc.nextLine();
            buffer.put(msg.getBytes());
            buffer.flip();
            sChannel.write(buffer);
            buffer.clear();
        }
    }
}
