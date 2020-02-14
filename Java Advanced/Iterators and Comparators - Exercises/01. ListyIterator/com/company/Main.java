package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<String> data = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(e->!e.equals("Create")).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        String input;

        while(!"END".equals(input=reader.readLine())){

            switch (input){
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
        }


    }
}


