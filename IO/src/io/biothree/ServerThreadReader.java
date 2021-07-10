package io.biothree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadReader extends Thread {
    private Socket socket;
    public ServerThreadReader(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg= br.readLine())!=null){
                System.out.println("服务端收到："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
