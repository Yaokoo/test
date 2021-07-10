package io.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnableTarget implements Runnable {
    private Socket socket;
    public ServerRunnableTarget(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        //处理接收到的客户端通信需求
        try {
            //System.out.println("服务端启动");
            InputStream is =socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg= br.readLine())!=null){
                System.out.println("服务器收到："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
