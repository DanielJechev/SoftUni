package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private  String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public  int getSize(){
        return this.data.size();
    }
    public void add( Rabbit rabbit){
        if (this.getCapacity()>this.getSize()) {
            this.data.add(rabbit);
        }
    }
    public boolean	removeRabbit(String name){
        boolean isRemoved= this.data.removeIf(r -> r.getName().equals(name));
        return isRemoved;

    }

    public void removeSpecies(String species){
        this.data.removeIf(a -> a.getName().equals(species));
    }
    public  Rabbit sellRabbit(String name){
        Rabbit rabit=this.data.stream().filter(a->a.getName().equals(name)).findFirst().orElse(null);
        return rabit;
    }
    public Rabbit sellRabbitBySpecies(String species){
        Rabbit out=this.data.stream().filter(a->a.getName().equals(species)).findFirst().orElse(null);
        return out;
    }

    public  int count(){
        return this.data.size();
    }


    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append( String.format("Rabbits available at %s:",this.name)).append(System.lineSeparator());
        for (Rabbit a:data) {
            sb.append(a).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
