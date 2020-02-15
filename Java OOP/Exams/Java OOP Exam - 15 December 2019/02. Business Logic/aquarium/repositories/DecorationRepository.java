package aquarium.repositories;

import aquarium.models.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {

    }

    @Override
    public boolean remove(Decoration decoration) {
        return false;
    }

    @Override
    public Decoration findByType(String type) {
        return null;
    }
}
