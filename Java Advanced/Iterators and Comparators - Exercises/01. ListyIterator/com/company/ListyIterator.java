package com.company;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int indexator;

    public ListyIterator(List<String> data) {
        this.data = data;
    }

    public boolean move (){
        if (hasNext()){
            indexator++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        if (this.indexator+1<this.data.size()){
            return true;
        }
        return false;
    }
    public void print(){
        if (this.data.isEmpty()){
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.data.get(this.indexator));
    }
}
