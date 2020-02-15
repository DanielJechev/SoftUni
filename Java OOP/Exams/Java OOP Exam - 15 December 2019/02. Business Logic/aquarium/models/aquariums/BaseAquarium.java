package aquarium.models.aquariums;

import aquarium.common.ExceptionMessages;
import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseAquarium  implements Aquarium{
    private String name;
    private  int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
if ( capacity>fish.getSize()){
     addFish(fish);
}else {
    throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
}
    }

    @Override
    public void removeFish(Fish fish) {
removeFish(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
  addDecoration(decoration);
    }

    @Override
    public void feed() {

    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }

    public void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
