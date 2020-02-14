package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(read.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> output = new ArrayList<>();

        if (read.readLine().equals("END")){
            Lake lake = new Lake(input);

            int index = 0;

            List<Integer> odd = new ArrayList<>();

            for (Integer num : lake) {
                if (index++%2==0){
                    output.add(num);
                }else {
                    odd.add(num);
                }
            }
            output.addAll(odd);
        }
        System.out.println(output.toString().replaceAll("[\\[\\]]",""));
    }
}
