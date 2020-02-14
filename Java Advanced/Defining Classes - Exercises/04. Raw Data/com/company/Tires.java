package com.company;

public class Tires {
    private double pressure;
    private int age ;
    private boolean fragile ;

    public void setPressure(double pressure) {
        this.pressure = pressure;
        if (pressure<1){
            fragile=true;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public boolean isFragile() {
        return fragile;
    }
}


