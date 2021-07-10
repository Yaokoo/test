package io.biothree;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("服务端已启动");
            ServerSocket ss=new ServerSocket(9999);
            //定义死循环 不断接收连接请求
            while (true){
                Socket socket=ss.accept();
                //创建独立的线程处理通信需求
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
