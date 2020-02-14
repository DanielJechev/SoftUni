package com.company;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;
public class Person {
    private String name;
    private Car car;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parient> parents;
    private List<Children> children;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.pokemon = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    public void addCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }

    public void addPokemon(String name, String type) {
        pokemon.add(new Pokemon(name, type));
    }

    public void addParents(String name, String birthday) {
        this.parents.add(new Parient(name, birthday));
    }

    public void addChildren (String name, String birthday) {
        this.children.add(new Children(name,birthday));
    }

    public void printInfo(){
        System.out.println(this.name);
        System.out.println("Company:");

        if (this.company!=null){
            System.out.println(this.company.getInfo());
        }

        System.out.println("Car:");
        if (this.car!=null){
            System.out.println(this.car.getInfo());
        }

        System.out.println("Pokemon:");
        this.pokemon.forEach(e-> System.out.println(e.getInfo()));

        System.out.println("Parents:");
        this.parents.forEach(e-> System.out.println(e.getInfo()));

        System.out.println("Children:");
        this.children.forEach(e-> System.out.println(e.getInfo()));
    }
}
