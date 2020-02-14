package Jar;

public class Sorter {
    public static <T extends Comparable<T>>void  sort(CustomList<T> list){
        for (int i = 0; i <list.size() -1; i++) {
            for (int j = i+1;j < list.size(); j++) {
if (list.get(i).compareTo(list.get(j))>0){
    list.swap(i,j);
}
            }
        }
    }
}
