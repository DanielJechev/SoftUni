package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet {
    private String name;
    private List<String> items;

    public PlanetImpl(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
