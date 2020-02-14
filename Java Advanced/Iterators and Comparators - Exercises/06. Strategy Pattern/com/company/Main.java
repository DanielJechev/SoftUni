package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> peoples = new TreeSet<>(new CompareNames());
        TreeSet<Person> people2 = new TreeSet<>(new CompareAges());

        int n = Integer.parseInt(read.readLine());

        for (int i = 0; i < n; i++) {
            String [] data = read.readLine().split("\\s+");

            Person person = new Person(data[0],Integer.parseInt(data[1]));

            peoples.add(person);
            people2.add(person);
        }

        peoples.forEach(System.out::println);
        people2.forEach(System.out::println);

    }
}
