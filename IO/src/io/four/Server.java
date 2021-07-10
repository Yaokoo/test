package io.four;

import java.net.ServerSocket;
import java.net.Socket;

//开发实现伪异步通信架构
public class Server {
    public static void main(String[] args) {
        try {
            //注册端口
            ServerSocket ss= new ServerSocket(9999);
            System.out.println("客户端启动");
            HandlerSocketServerPool pool=new HandlerSocketServerPool(6,10);
            while (true){
                Socket socket =ss.accept();
                //把socket交给线程池处理
                //把socket封装成任务对象
                Runnable target=new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
