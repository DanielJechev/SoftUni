package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        String input;

        while(!"END".equals(input=read.readLine())){

            String[] data = input.split("\\s+");

            Person person = new Person(data[0],data[2],Integer.parseInt(data[1]));

            people.add(person);

        }

        Person person = people.get(Integer.parseInt(read.readLine())-1);

        int count = (int) people.stream().filter(e->e.compareTo(person)==0).count();

        if (count==1){
            System.out.println("No matches");
        }else {
            System.out.println(String.format("%d %d %d",count,people.size()-count,people.size()));
        }

    }
}
