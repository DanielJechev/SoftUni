package motocrossWorldChampionship.entities.interfaces;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Rider> getRiders();

    void addRider(Rider rider);
}
