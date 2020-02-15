package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private  double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag=new Backpack();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
        // default return false;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
if (this.oxygen-10<0){
    this.oxygen=0;
}else {
    this.oxygen-=10;
}

    }
    void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }



}
