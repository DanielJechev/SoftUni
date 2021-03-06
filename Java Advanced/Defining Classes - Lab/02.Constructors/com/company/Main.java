package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(reader.readLine());
        List<Car> cars=new ArrayList<>();
        for (int i = 0; i <count ; i++) {
            String[] tokens=reader.readLine().split(" ");
            if(tokens.length>1) {
                String make = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(make,model, horsePower);
                cars.add(car);
            }else {
                String make = tokens[0];
                Car car = new Car(make);
                cars.add(car);
            }
        }
        cars.forEach(c-> System.out.println(c.carInfo()));
    }
}
