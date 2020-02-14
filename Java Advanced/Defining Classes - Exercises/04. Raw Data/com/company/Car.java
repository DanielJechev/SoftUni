package com.company;
import java.util.List;
public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tires> tires;

    public Car(String model , int engineSpeed , int enginePower , int cargoWeight , String cargoType , List<Tires>tires) {
        this.model = model;
        engine = new Engine(engineSpeed,enginePower);
        cargo = new Cargo(cargoWeight,cargoType);
        this.tires=tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return model;
    }

    public List<Tires> getTires() {
        return tires;
    }

}
