package com.company;

public enum Enumeration {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);
    private int code;

    Enumeration(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
