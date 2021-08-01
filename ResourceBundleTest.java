import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle bundle=ResourceBundle.getBundle("classinfo");
        String className=bundle.getString("className");
    }
}
