package com.company;

public enum  Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);
    private int code;

    Season(int code) {
        this.code = code;
    }
    public int getCode(){
        return this.code;

    }
}
