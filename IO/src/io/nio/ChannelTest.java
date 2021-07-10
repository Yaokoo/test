package io.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    @Test
    public void write() {
        try {
            //字节输出流通向文件目标
            FileOutputStream fos = new FileOutputStream("data01.txt");
            //字节输出流对应的通道
            FileChannel fileChannel = fos.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello world".getBytes());
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            fileChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() {
        try {
            FileInputStream fis=new FileInputStream("data01.txt");
            FileChannel channel=fis.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            String s=new String(buffer.array());
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copy(){
        try {

            FileInputStream fis=new FileInputStream("D:/存/jiu.txt");
            FileOutputStream fos=new FileOutputStream("D:/存/jiunew.txt");
            FileChannel fisChannel=fis.getChannel();
            FileChannel fosChannel=fos.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            while (true){
                buffer.clear();
                int flag=fisChannel.read(buffer);
                if(flag==-1){
                    break;
                }
                    buffer.flip();
                    fosChannel.write(buffer);
            }
            fisChannel.close();
            fosChannel.close();
            System.out.println("复制成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test(){
        try {
            FileInputStream fis=new FileInputStream("data01.txt");
            FileChannel inchannel=fis.getChannel();

            FileOutputStream fos=new FileOutputStream("data02.txt");
            FileChannel oschannel=fos.getChannel();
            ByteBuffer buffer1=ByteBuffer.allocate(4);
            ByteBuffer buffer2=ByteBuffer.allocate(10);
            ByteBuffer[] buffers={buffer1,buffer2};
            inchannel.read(buffers);
            for(ByteBuffer b:buffers){
                b.flip();
                System.out.println(new String(b.array(),0,b.remaining()));
            }
            oschannel.write(buffers);
            inchannel.close();
            oschannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test02(){
        try {
            FileInputStream fis=new FileInputStream("data01.txt");
            FileOutputStream fos=new FileOutputStream("data04.txt");

            FileChannel fisChannel=fis.getChannel();
            FileChannel fosChannel=fos.getChannel();

            //fosChannel.transferFrom(fisChannel, fisChannel.position(),fisChannel.size());
            fisChannel.transferTo(fisChannel.position(),fisChannel.size(),fosChannel);//都是拿到源通道的位置与长度
            fisChannel.close();
            fosChannel.close();
            System.out.println("复制完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
