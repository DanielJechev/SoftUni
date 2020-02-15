package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Class r=BlackBoxInt.class;

        Constructor constructor = r.getDeclaredConstructor();

        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        Method[] declaredMethods = r.getDeclaredMethods();

        Field innerValue = r.getDeclaredField("innerValue");

        innerValue.setAccessible(true);

        String input;
        while (!"END".equals(input = read.readLine())) {
            String[] data = input.split("_");
            int value = Integer.parseInt(data[1]);
            for (Method declaredMethod : declaredMethods) {

                if (declaredMethod.getName().equals(data[0])) {

                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(blackBoxInt, value);
                    break;
                }
            }
            System.out.println(innerValue.getInt(blackBoxInt));
        }

    }



    }
