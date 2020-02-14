package dani;

public class Sorter {


    public static <T extends Comparable<T>> void sort (CustomList<T> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size()-i; j++) {
                if (list.get(i).compareTo(list.get(j))>0){
                    list.swap(i,j);
                }
            }
        }
    }
}
