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
        int n = Integer.parseInt(read.readLine());


        Map<String, Engine> engines = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] engineData = read.readLine().split("\\s+");

            Engine engine = new Engine(engineData[0], Integer.parseInt(engineData[1]));

            switch (engineData.length) {
                case 3:
                    engine = new Engine(engineData[0], Integer.parseInt(engineData[1]));

                    if (Character.isDigit(engineData[2].charAt(0))) {
                        engine.setDisplacement(engineData[2]);
                    }else {
                        engine.setEfficiency(engineData[2]);
                    }
                    break;
                case 4:
                    engine = new Engine(engineData[0], Integer.parseInt(engineData[1]));
                    engine.setDisplacement(engineData[2]);
                    engine.setEfficiency(engineData[3]);
                    break;
            }
            engines.put(engineData[0], engine);
        }

        n = Integer.parseInt(read.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = read.readLine().split("\\s+");

            Car car = new Car(carData[0],engines.get(carData[1]));

            switch (carData.length){
                case 3:
                    if (Character.isDigit(carData[2].charAt(0))){
                        car.setWeight(carData[2]);
                    }else {
                        car.setColor(carData[2]);
                    }
                    break;
                case 4:
                    car.setWeight(carData[2]);
                    car.setColor(carData[3]);
                    break;
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);


    }
}
