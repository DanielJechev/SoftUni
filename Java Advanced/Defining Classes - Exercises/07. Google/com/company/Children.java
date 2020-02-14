package com.company;

public class Children {
    private String name;
    private String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getInfo(){
        return this.name + " " + this.birthday;
    }
}
