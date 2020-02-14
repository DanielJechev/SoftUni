package dani;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList <T extends Comparable<T>> {
        private List<T> data;

        public CustomList() {
            this.data = new ArrayList<>();
        }
        public void add (T element){
            this.data.add(element);
        }
        public T get (int index){
            return this.data.get(index);
        }
        public void remove (int index){
            this.data.remove(index);
        }
        public int size (){
            return this.data.size();
        }
        public boolean contains (T element){
            return this.data.contains(element);
        }
        public void swap(int firstIndex , int secondIndex){
            Collections.swap(this.data,firstIndex,secondIndex);
        }
        public int countGreaterThan (T element){
            return (int)this.data.stream().filter(e->e.compareTo(element)>0).count();
        }
        public T getMax (){
            return Collections.max(this.data);
        }
        public T getMin(){
            return Collections.min(this.data);
        }
}
