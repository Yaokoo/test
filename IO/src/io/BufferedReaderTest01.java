package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
    public static void main(String[] args)  {
        FileReader reader= null;
        BufferedReader br=null;
        try {
            reader = new FileReader("myfile");
            br=new BufferedReader(reader);
            String s=null;
            while((s= br.readLine())!=null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //读一行
       /* String firstLine=br.readLine();
        System.out.println(firstLine);
        String secondLine= br.readLine();
        System.out.println(secondLine);*/
    }
}
