package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private Set<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashSet<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return null;
    }

    @Override
    public void add(Astronaut model) {

    }

    @Override
    public boolean remove(Astronaut model) {
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        return null;
    }
}
