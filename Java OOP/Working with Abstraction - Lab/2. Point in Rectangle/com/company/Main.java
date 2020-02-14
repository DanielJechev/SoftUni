package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
int[] coordinates=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
Point bottomLeft=new Point(coordinates[0],coordinates[1]);
Point topRight=new Point(coordinates[2],coordinates[3]);
Rectangle rectangle=new Rectangle(bottomLeft,topRight);
int pointCount=Integer.parseInt(reader.readLine());
        for (int i = 0; i <pointCount ; i++) {
int[] pointCordinates=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
Point newPoint=new Point(pointCordinates[0],pointCordinates[1]);
            System.out.println(rectangle.contains(newPoint));
        }
    }
}
