package Jar;

import java.util.ArrayList;
import java.util.List;

public class Jar <T>{
    private List<T> element;

    public Jar() {
        this.element = new ArrayList<>();
    }

    public void add(T element){
        this.element.add(element);
    }

    public T remove(){
        return this.element.remove(this.element.size()-1);
    }

}
