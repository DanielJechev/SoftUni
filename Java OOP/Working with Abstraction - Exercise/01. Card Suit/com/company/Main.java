package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader reader=new BufferedReader (new InputStreamReader(System.in));
    String input=reader.readLine();
        System.out.println(input+":");
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.CLUBS.getCode(), Enumeration.CLUBS));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.DIAMONDS.getCode(), Enumeration.DIAMONDS));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.HEARTS.getCode(), Enumeration.HEARTS));
        System.out.println(String.format("Ordinal value: %s; Name value: %s", Enumeration.SPADES.getCode(), Enumeration.SPADES));


    }

        }
