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



        int n = Integer.parseInt(reader.readLine());

        List<String> elements = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            elements.add(reader.readLine());
        }

        System.out.println(getCount(elements, reader.readLine()));

    }
    private static <E extends Comparable<E>> int getCount (List<E> list ,E compareParameter ){

        int count = 0;

        for (E element : list) {
            if (element.compareTo(compareParameter)>0){
                count++;
            }
        }
        return count;
    }
}
