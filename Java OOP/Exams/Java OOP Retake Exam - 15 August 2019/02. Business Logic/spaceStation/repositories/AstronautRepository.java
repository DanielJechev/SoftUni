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
        return this.astronauts;
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.removeIf(p->p.getName().equals(model.getName()));
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
}
