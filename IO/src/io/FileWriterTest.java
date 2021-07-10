package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fw=null;
        try {
            fw=new FileWriter("myfile");
            char[] chars={'练','习'};
            fw.write(chars);
            fw.write("lbfmeiyouma");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
