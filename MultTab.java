import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class MultTab {

    public static void main(String[] args) throws FileNotFoundException
    {
        PrintStream ps=new PrintStream(new File("D:\\MultTab.txt"));
        for(int i=1;i<=9;i++)
        {
            for(int j=1;j<=i;j++)
            {
                ps.print(i+"*"+j+"="+i*j+"\t");
            }
            ps.println();
        }

    }
}