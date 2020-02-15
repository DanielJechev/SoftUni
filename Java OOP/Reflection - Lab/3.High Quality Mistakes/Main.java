import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
   Class r=Reflection.class;


        Field[] declaredFields = r.getDeclaredFields();
        declaredFields=Arrays.stream(declaredFields).sorted(Comparator.comparing(Field::getName)).toArray(Field[]::new);
        for (Field declaredField:declaredFields) {

            if (!Modifier.isPrivate(declaredField.getModifiers())){
                System.out.println(String.format("%s must be private!",declaredField.getName()));
            }
        }

        Method[] declaredMethods = r.getDeclaredMethods();
        declaredMethods=Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        for (Method declaredMethod:declaredMethods) {
            String name=declaredMethod.getName();
            if (name.contains("get")&&!Modifier.isPublic(declaredMethod.getModifiers())){
                System.out.println(String.format("%s have to be public!",declaredMethod.getName()));
            }
        }
        for (Method declaredMethod:declaredMethods) {
            String name=declaredMethod.getName();
            if (name.contains("set")&&!Modifier.isPrivate(declaredMethod.getModifiers())){
                System.out.println(String.format("%s have to be private!",declaredMethod.getName()));
            }
        }
    }
}

