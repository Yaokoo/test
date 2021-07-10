package io.biotwo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动===");
            //1.定义一个对象进行服务端的端口注册
            ServerSocket ss=new ServerSocket(9999);
            //2.监听客户端的Socket请求
            Socket socket=ss.accept();
            //3.从socket管道中得到一个字节输入流对象
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg= br.readLine())!=null) {
                System.out.println("服务端接收到："+msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
