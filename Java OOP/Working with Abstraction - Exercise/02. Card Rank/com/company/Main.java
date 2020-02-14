package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader reader=new BufferedReader (new InputStreamReader(System.in));
    String input=reader.readLine();
        System.out.println(input+":");
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.ACE.getCode(), Enumeration.ACE));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.TWO.getCode(), Enumeration.TWO));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.THREE.getCode(), Enumeration.THREE));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.FOUR.getCode(), Enumeration.FOUR));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.FIVE.getCode(), Enumeration.FIVE));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.SIX.getCode(), Enumeration.SIX));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.SEVEN.getCode(), Enumeration.SEVEN));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.EIGHT.getCode(), Enumeration.EIGHT));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.NINE.getCode(), Enumeration.NINE));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.TEN.getCode(), Enumeration.TEN));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.JACK.getCode(), Enumeration.JACK));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.QUEEN.getCode(), Enumeration.QUEEN));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.KING.getCode(), Enumeration.KING));


    }

        }
