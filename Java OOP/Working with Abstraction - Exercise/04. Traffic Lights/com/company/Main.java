package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader reader=new BufferedReader (new InputStreamReader(System.in));
Traffic[] tokens= Arrays.stream(reader.readLine().split(" ")).map(Traffic::valueOf).toArray(Traffic[]::new);
int n=Integer.parseInt(reader.readLine());
Traffic[] lights=Traffic.values();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < tokens.length; j++) {
int index=(tokens[j].ordinal()+1)%lights.length;
tokens[j]=lights[index];
                System.out.print(tokens[j].toString()+" ");
            }
            System.out.println();


        }

    }

        }
