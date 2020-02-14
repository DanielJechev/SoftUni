package Jar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String line = read.readLine();

        Tuple<String,String> nameAndAddress =
                new Tuple<>(line.substring(0, line.lastIndexOf(" ")), line.substring(line.lastIndexOf(" ") + 1));

        System.out.println(nameAndAddress.toString());

        String[] data = read.readLine().split("\\s+");

        Tuple<String,Integer> nameAndLitersBeer = new Tuple<>(data[0], Integer.parseInt(data[1]));

        System.out.println(nameAndLitersBeer);

        data = read.readLine().split("\\s+");

        Tuple<Integer,Double> tuple = new Tuple<>(Integer.parseInt(data[0]), Double.parseDouble(data[1]));

        System.out.println(tuple.toString());

    }


}
