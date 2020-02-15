package motocrossWorldChampionship.entities.interfaces;

import java.util.Collection;

import static motocrossWorldChampionship.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Rider> riders;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return null;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider==null){
            throw new NullPointerException(RIDER_INVALID);
        }
        //
    }

    public void setName(String name) {
        if (this.name==null||this.name.trim().length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name,5));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (this.laps<1){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS,1));

        }
        this.laps = laps;
    }
}
