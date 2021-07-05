import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest02 {
    public static void main(String[] args) throws Exception {
        Class studentClass=Class.forName("bean.Student");
        Field[] fields=studentClass.getFields();
        System.out.println(fields.length);
        Field f=fields[0];
        System.out.println(f.getName());
        System.out.println("--------------");

        Field[] fs=studentClass.getDeclaredFields();
        System.out.println(fs.length);
        for(Field field:fs){
            int modifiersCount=field.getModifiers();
            String modifierName=Modifier.toString(modifiersCount);
            Class type=field.getType();
            System.out.println(modifierName+"---"+type.getSimpleName()+"---"+field.getName());
            //System.out.println(field.getName());
        }
    }
}
