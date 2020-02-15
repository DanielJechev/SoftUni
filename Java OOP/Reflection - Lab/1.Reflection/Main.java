import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class r =Reflection.class;
        System.out.println(r);
        System.out.println(r.getSuperclass());
        for (Class<?> interfaces:r.getInterfaces()){
            System.out.println(interfaces);
        }
        System.out.println(r.getDeclaredConstructor().newInstance());

    }
}
