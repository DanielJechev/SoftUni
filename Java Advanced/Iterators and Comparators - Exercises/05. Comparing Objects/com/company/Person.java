package com.company;

public class Person implements Comparable<Person> {
    private String name;
    private String town;
    private int age;

    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.getName())==0){
            if (this.age == person.getAge()){
                return this.town.compareTo(person.getTown());
            }
            return Integer.compare(this.age,person.getAge());
        }
        return this.name.compareTo(person.getName());
    }
}