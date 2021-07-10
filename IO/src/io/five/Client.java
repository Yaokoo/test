package io.five;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",8888);
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(".txt");
            InputStream is=new FileInputStream("D:/jiu.txt");
            byte[] bytes=new byte[1024*1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                dos.write(bytes,0,len);
            }
            dos.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
