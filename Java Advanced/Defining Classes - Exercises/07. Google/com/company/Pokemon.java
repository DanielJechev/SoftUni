package com.company;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getInfo(){
        return this.name + " " + this.type;
    }
}
