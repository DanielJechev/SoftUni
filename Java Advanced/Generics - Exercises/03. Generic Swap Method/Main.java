package dani;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<String> elements = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            elements.add(reader.readLine());
        }

        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        swapElements(elements,indexes);

        elements.forEach(e-> System.out.println(e.getClass().getName()+": "+e));

    }

    private static <T> void  swapElements (List<T> list , int[] indexes){
        T element = list.get(indexes[0]);
        list.set(indexes[0],list.get(indexes[1]));
        list.set(indexes[1],element);
    }
}
