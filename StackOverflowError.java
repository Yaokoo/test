public class StackOverflowError {
    static  int i=0;
    public static void a(){
        i++;
        a();
    }
    public static void main(String[] args) {
        StackOverflowError.a();
    }
}

