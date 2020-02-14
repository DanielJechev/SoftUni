package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader reader=new BufferedReader (new InputStreamReader(System.in));
    String first=reader.readLine();
    String second=reader.readLine();
     int result=Rank.valueOf(first).getCode()+Suit.valueOf(second).getCode();
        System.out.println(String.format("Card name: %s of %s; Card power: %d",first,second,result));

    }

        }
