package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Person> persons = new LinkedHashMap<>();

        String input;

        while(!"End".equals(input=read.readLine())){

            String[] data = input.split("\\s+");

            persons.putIfAbsent(data[0],new Person(data[0]));

            switch (data[1]){
                case "company":
                    persons.get(data[0]).addCompany(data[2],data[3],Double.parseDouble(data[4]));
                    break;
                case "pokemon":
                    persons.get(data[0]).addPokemon(data[2],data[3]);
                    break;
                case "parents":
                    persons.get(data[0]).addParents(data[2],data[3]);
                    break;
                case "children":
                    persons.get(data[0]).addChildren(data[2],data[3]);
                    break;
                case "car":
                    persons.get(data[0]).addCar(data[2],Integer.parseInt(data[3]));
                    break;
            }

        }
        persons.get(read.readLine()).printInfo();
    }
}
