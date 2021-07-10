package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest{
    //用记事本打不开
    public static void main(String[] args) throws Exception{
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("data"));
        dos.flush();
        dos.close();
    }
}
