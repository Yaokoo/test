import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {
    static class Test{}
        public static void main(String[] args) {
            List<Test> list=new ArrayList<>();
            while(true){
                list.add(new Test());
            }
        }
}


