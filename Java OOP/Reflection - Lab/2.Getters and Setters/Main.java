import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class ref = Reflection.class;

        Method[] declaredMethods = ref.getDeclaredMethods();

        declaredMethods = Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);

        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();

            if (name.contains("get")) {
                System.out.println(String.format("%s will return class %s", name, declaredMethod.getReturnType().getName()));
            }

        }
        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();

            if (name.contains("set")) {

                System.out.print(String.format("%s and will set field of class ", name));

                Parameter[] parameterTypes = declaredMethod.getParameters();

                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getType().getName() + " ");
                }
                System.out.println();
            }

        }
    }
}