import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest03 {
    /**
     * 反编译
     */
    public static void main(String[] args) throws Exception {
        StringBuilder s=new StringBuilder();

        Class studentClass=Class.forName("java.lang.Integer");
        s.append(Modifier.toString(studentClass.getModifiers()) +" class "+studentClass.getSimpleName()+"{\n");
        Field[] fields=studentClass.getDeclaredFields();
        for(Field field:fields){
            s.append("\t");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";"+"\n");
        }
        s.append("}");
        System.out.println(s);
    }
}
