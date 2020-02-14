package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStack<T> implements Iterable<T> {

    private final int DEFAULT_CAPACITY = 5;

    private T [] data;
    private int size;
    private int capacity;

    public CustomStack (){
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void push (T element){
        checkCapacity();
        this.data[this.size++] = element;
    }

    public T pop(){

        checkEmpty();

        T e = this.data[this.size-1];

        this.data[this.size-1] = null;

        if(this.data[this.capacity/2]==null){
            downSize();
        }

        this.size--;
        return e;
    }

    private void checkEmpty() {
        if (this.size==0){
            throw new NoSuchElementException("CustomStack is empty!");
        }
    }

    public T peek (){
        checkEmpty();

        return this.data[this.size-1];
    }

    private void checkCapacity(){
        if (this.size>=this.capacity){
            resize();
        }
    }

    private void downSize(){
        T[] newArray = (T[]) new Object[this.capacity/2];
        if (this.size / 2 >= 0) System.arraycopy(this.data, 0, newArray, 0, this.size-1);
        this.data = newArray;
        this.capacity = this.capacity/2;
    }

    private void resize() {
        T[] newArray = (T[]) new Object [this.size*2];
        if (this.capacity >= 0) System.arraycopy(this.data, 0, newArray, 0, this.capacity);
        this.capacity = this.size*2;
        this.data = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = size-1;

            @Override
            public boolean hasNext() {
                return this.index>=0;
            }

            @Override
            public T next() {
                return data[index--];
            }
        };
    }
}
