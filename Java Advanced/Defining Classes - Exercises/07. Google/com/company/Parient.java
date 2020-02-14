package com.company;

public class Parient {
    private String name;
    private String birthday;

    public Parient(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getInfo(){
        return this.name+" "+this.birthday;
    }
}
