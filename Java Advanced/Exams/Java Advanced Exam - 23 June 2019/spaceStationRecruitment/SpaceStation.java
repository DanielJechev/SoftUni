package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private List<Astronaut> astronauts;
    private String name;
    private  int capacity;

    public SpaceStation( String name, int capacity) {
        this.astronauts = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return this.name;
    }
    public   int getCount(){
        return this.astronauts.size();
    }
    public  void add(Astronaut astronaut){
        if (this.getCapacity()>this.getCount()) {
            this.astronauts.add(astronaut);
        }
    }
    public boolean remove(String name){
       boolean isRemoved= this.astronauts.removeIf(astronaut -> astronaut.getName().equals(name));
        return isRemoved;


    }
    public Astronaut getOldestAstronaut(){
        Astronaut astronaut=null;
        int max=-1;
        for (Astronaut a:astronauts) {
            if (a.getAge()>max){
                max=a.getAge();
                astronaut=a;
            }
        }
        return astronaut;
    }

    public  Astronaut getAstronaut(String name){
        Astronaut astronaut=this.astronauts.stream().filter(a->a.getName().equals(name)).findFirst().orElse(null);
        return astronaut;
    }

    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append( String.format("Astronauts working at Space Station %s:",this.name)).append(System.lineSeparator());
        for (Astronaut a:astronauts) {
            sb.append(a).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
