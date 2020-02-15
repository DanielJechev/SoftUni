package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.List;

public class GunRepository implements Repository<Gun> {

    private List<Gun> models;


    @Override
    public Collection<Gun> getModels() {
        return null;
    }

    @Override
    public void add(Gun model) {

    }

    @Override
    public boolean remove(Gun model) {
        return false;
    }

    @Override
    public Gun find(String name) {
        return null;
    }
}
