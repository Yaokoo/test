import bean.Student;

import java.lang.reflect.Field;

public class ReflectTest04 {
    public static void main(String[] args) throws Exception {
        /*Student s=new Student();
        s.no=1111;
        System.out.println(s.no);*/

        Class studentClass=Class.forName("bean.Student");
        Object obj=studentClass.newInstance();
        Field nofield=studentClass.getDeclaredField("no");
        nofield.set(obj,111);
        System.out.println(nofield);
        System.out.println(nofield.get(obj));

        Field nameField=studentClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj,"jack");
        System.out.println(nameField.get(obj));
    }
}
