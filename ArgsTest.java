public class ArgsTest {
    public static void main(String[] args) {
        m();
        m(1);
        m(1,2);

        x(1);
        x(2,"xx");

    }
    public static void m(int... a){
        System.out.println("m执行");
    }

    public static void x(int a,String... b){
        System.out.println("x执行");
    }
}
