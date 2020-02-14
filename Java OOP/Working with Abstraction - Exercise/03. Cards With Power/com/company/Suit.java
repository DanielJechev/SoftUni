package com.company;

public enum  Suit {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS  (26),
    SPADES (39);
private int code;

    Suit(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }
}
