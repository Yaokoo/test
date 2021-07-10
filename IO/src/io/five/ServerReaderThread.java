package io.five;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class ServerReaderThread extends Thread{
   private Socket socket;
   public ServerReaderThread(Socket socket){
       this.socket=socket;
   }

    @Override
    public void run() {
        try {
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            String suffix=dis.readUTF();
            System.out.println("服务端已成功接收文件类型"+suffix);
            OutputStream os=new FileOutputStream("D:/存/jiu.txt");
            byte[] bytes=new byte[1024*1024];
            int len;
            while ((len=dis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
         os.close();
            System.out.println("服务端接收文件保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
