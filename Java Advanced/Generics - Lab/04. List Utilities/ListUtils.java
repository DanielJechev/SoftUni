package Jar;

import java.util.List;

public class ListUtils {
    public static  <T extends Comparable<T>> T getMin(List<T> elements){
        if (elements==null||elements.size()==0){
            throw new IllegalArgumentException();
        }
        T firstElement=elements.get(0);
        for (T element:elements) {
            if (firstElement.compareTo(element)>0){
                firstElement=element;
            }
        }
        return firstElement;
    }
    public static  <T extends Comparable<T>> T getMax(List<T> elements){
        if (elements==null||elements.size()==0){
            throw new IllegalArgumentException();
        }
        T firstElement=elements.get(0);
        for (T element:elements) {
            if (firstElement.compareTo(element)<0){
                firstElement=element;
            }
        }
        return firstElement;
    }
}
