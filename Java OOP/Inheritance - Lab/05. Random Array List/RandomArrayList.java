package com;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
     private  static  final Random RANDOM;
     static {
         RANDOM=new Random();
     }
     public  Object getRandomElement(){
         Object o=super.get(RANDOM.nextInt(super.size()));
         super.remove(o);
         return o;
     }

}
