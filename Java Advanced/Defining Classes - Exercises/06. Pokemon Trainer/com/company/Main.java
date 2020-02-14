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
        Map<String,Trainer> trainers = new LinkedHashMap<>();

        String input;

        while(!"Tournament".equals(input=read.readLine())){

            String[] data = input.split("\\s+");

            Trainer trainer = new Trainer(data[0]);

            trainers.putIfAbsent(data[0],trainer);
            trainers.get(data[0]).addPokemon(new Pokemon(data[1],data[2],Integer.parseInt(data[3])));

        }

        while(!"End".equals(input=read.readLine())){

            for (Trainer trainer : trainers.values()) {

                if (trainer.containsPokemonsWithGivenElement(input)){
                    trainer.increaseBadges();
                }else {
                    trainer.decreasePokemonHealth();
                }
            }

        }

        trainers.entrySet().stream()
                .sorted((t1,t2)->Integer.compare(t2.getValue().getNumberOfBadges(),t1.getValue().getNumberOfBadges()))
                .forEach(e-> System.out.println(e.getValue().toString()));

    }
}
