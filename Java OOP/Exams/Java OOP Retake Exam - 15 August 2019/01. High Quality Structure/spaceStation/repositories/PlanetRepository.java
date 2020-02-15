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
        return null;
    }

    @Override
    public void add(Planet model) {

    }

    @Override
    public boolean remove(Planet model) {
        return false;
    }

    @Override
    public Planet findByName(String name) {
        return null;
    }
}
