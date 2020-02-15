package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String input=reader.readLine();

        Class r= RichSoilLand.class;
        Field[] declaredFields = r.getDeclaredFields();
        while (!input.equals("HARVEST")){
        for (Field declaredField:declaredFields) {
            String name = declaredField.getName();
            if (input.equals("private")) {
                if (Modifier.isPrivate(declaredField.getModifiers())) {
                    System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getType().getSimpleName() + " " + name);
                }
            }
            if (input.equals("public")) {
                if (Modifier.isPublic(declaredField.getModifiers())) {
                    System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getType().getSimpleName() + " " + name);
                }
            }
            if (input.equals("protected")) {
                if (Modifier.isProtected(declaredField.getModifiers())) {
                    System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getType().getSimpleName() + " " + name);
                }
            }if (input.equals("all")) {
                System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getType().getSimpleName() + " " + name);
                }


        }
            input=reader.readLine();



}

    }
}
