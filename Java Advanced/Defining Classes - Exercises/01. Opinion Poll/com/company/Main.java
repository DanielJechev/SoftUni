package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        List<Person> input=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] tokens=reader.readLine().split(" ");
            String name=tokens[0];
            int age=Integer.parseInt(tokens[1]);
            Person person=new Person(name,age);
            input.add(person);
        }
        input.sort(Comparator.comparing(Person::getName));
     input.stream().filter(person -> person.getAge()>30).forEach(e->
             System.out.println(String.format("%s - %d",e.getName(),e.getAge())));

    }

}
