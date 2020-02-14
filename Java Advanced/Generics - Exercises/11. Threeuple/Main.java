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

        String[] data = read.readLine().split("\\s+");

        Threeuple<String,String,String> nameAddressTown = new Threeuple<>(data[0] + " " + data[1], data[2], data[3]);

        System.out.println(nameAddressTown);

        data = read.readLine().split("\\s+");

        Threeuple<String,Integer,Boolean> nameLiterBeerDrunk;

        if (data[2].equals("drunk")){
            nameLiterBeerDrunk = new Threeuple<>(data[0], Integer.parseInt(data[1]), true);
        }else {
            nameLiterBeerDrunk = new Threeuple<>(data[0], Integer.parseInt(data[1]), false);
        }

        System.out.println(nameLiterBeerDrunk);

        data = read.readLine().split("\\s+");

        Threeuple<String,Double,String> nameBalanceBank = new Threeuple<>(data[0], Double.parseDouble(data[1]), data[2]);

        System.out.println(nameBalanceBank);
    }


}
