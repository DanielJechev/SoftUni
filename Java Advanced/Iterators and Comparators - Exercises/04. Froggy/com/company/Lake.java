package com.company;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] data ;

    public Lake(int[] data) {
        this.data = data;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer>{

        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index<data.length;
        }

        @Override
        public Integer next() {
            return data[index++];
        }
    }
}