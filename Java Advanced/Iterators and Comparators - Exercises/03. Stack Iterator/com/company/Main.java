package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));


        CustomStack<Integer> customStack = new CustomStack<>();

        int [] data = Arrays.stream(read.readLine().split("([, ]+)")).skip(1).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(data).forEach(customStack::push);

        String input;
        try {

            while(!"END".equals(input=read.readLine())){

                String[] com = input.split("\\s+");

                switch (com[0]){
                    case "Pop":
                        customStack.pop();
                        break;
                    case "Push":
                        customStack.push(Integer.parseInt(com[1]));
                        break;
                }
            }

        }catch (NoSuchElementException e ){
            System.out.println("No elements");
        }
        customStack.forEach(System.out::println);
        customStack.forEach(System.out::println);
    }
}
