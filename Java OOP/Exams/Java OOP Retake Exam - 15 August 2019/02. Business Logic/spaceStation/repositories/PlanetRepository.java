package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetRepository implements Repository<Planet> {
    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }


    @Override
    public Collection<Planet> getModels() {
        return this.planets;
    }

    @Override
    public void add(Planet model) {
        this.planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.removeIf(p->p.getName().equals(model.getName()));
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
}
