package com.company;

public enum  Discount {
    VIP(20),
    SecondVisit(10),
    None(0);
    private int code;

    Discount(int code) {
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
}
