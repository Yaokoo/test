package com.http;

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author yaokoo
 * @create 2021/7/31 23:20
 */
public class Server {
    public static void main(String[] args) {
        try {
                ServerSocket serverSocket=new ServerSocket(9000);
            for (;;) {
                Socket socket=serverSocket.accept();

                String s;
                InputStream in=socket.getInputStream();
                BufferedReader br1=new BufferedReader(new InputStreamReader(in));
                byte[] bytes1=new byte[1024];
                s=br1.readLine();
                System.out.println(s);
/*                while ((s=br1.readLine())!=null) {
                     s1=s;
                    System.out.println(s);
                }*/
                String[] ss=s.split(" ");
                String path="D://readwrite//"+ss[1].substring(1);
                System.out.println(path);
                // System.out.println("request from client\n"+socket.getInetAddress().getHostName());


          /*   String request = "GET /index.html HTTP/1.1\r\n"+
                     "Host: 192.168.194.129:8080\r\n";*/


                InputStream inputStream=new FileInputStream(path);
                byte[] bytes2=new byte[1024];
                inputStream.read(bytes2);
                String str=new String(bytes2);

                System.out.println(str);

                String request="HTTP/1.1 200 OK\n"+
                        //"Date: Sat 31 Dec 2008 22:22:22 GMT\n"+
                        "Content-Type: text/html;charset=utf-8\n"+
                        "Context-Length: "+str.getBytes().length+"\n"+"\n"+str;
                //System.out.println(str);
                OutputStream out=socket.getOutputStream();
                out.write(request.getBytes(StandardCharsets.UTF_8));
                out.flush();



                //返回给服务端
/*                OutputStream out=socket.getOutputStream();
                out.write(str.getBytes(StandardCharsets.UTF_8));*/
            /*    out.flush();
                socket.close();*/
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
