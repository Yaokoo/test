import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest05 {
    public static void main(String[] args) throws Exception {
        /*Class testClass=Class.forName("Test");
        Method[] methods=testClass.getDeclaredMethods();
        System.out.println(methods.length);*/

        /*for(Method method:methods){
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getSimpleName());
            System.out.println(method.getName());
            Class[] parameterTypes=method.getParameterTypes();
            for(Class parameter:parameterTypes){
                System.out.println(parameter.getSimpleName());
            }
        }*/
        Class testClass=Class.forName("Test");
        Object obj=testClass.newInstance();

        Method method=testClass.getDeclaredMethod("b", int.class, int.class);
        Object retValue=method.invoke(obj,1,2);
        System.out.println(retValue);
    }
}
