package com.company;

import java.util.Comparator;

public class CompareNames implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length()==o2.getName().length()){
            return o1.getName().toLowerCase().charAt(0)-o2.getName().toLowerCase().charAt(0);
        }
        return o1.getName().length()-o2.getName().length();
    }
}
