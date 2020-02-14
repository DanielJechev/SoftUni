package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = read.readLine().split("\\s+");

            List<Tires> tires = new ArrayList<>();

            for (int j = 5; j < data.length; j+=2) {

                double pressure = Double.parseDouble(data[j]);
                int age = Integer.parseInt(data[j+1]);

                Tires tire = new Tires();
                tire.setAge(age);
                tire.setPressure(pressure);

                tires.add(tire);
            }

            Car car = new Car(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4],tires);
            cars.add(car);
        }

        if (read.readLine().equals("fragile")){
            cars.forEach(e->{
                List<Tires> tires = e.getTires().stream().filter(Tires::isFragile).collect(Collectors.toList());
                if (!tires.isEmpty()){
                    System.out.println(e.getModel());
                }
            });

        }else {

            Predicate<Car> validateByCriteria = e->e.getCargo().getCargoType().equals("flamable")&&e.getEngine().getEnginePower()>250;

            cars.stream().filter(validateByCriteria).forEach(e-> System.out.println(e.getModel()));
        }

    }
}
