import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class ReflectTest01 {
    public static void main(String[] args) throws Exception {
        //String path=Thread.currentThread().getContextClassLoader().getResource("classinfo.properties").getPath();
        InputStream reader =Thread.currentThread().getContextClassLoader().getResourceAsStream("classinfo.properties");
        Properties pro=new Properties();
        pro.load(reader);
        reader.close();

        String className=pro.getProperty("className");
        Class a=Class.forName(className);
        Object o=a.newInstance();
        System.out.println(o);
    }
}
