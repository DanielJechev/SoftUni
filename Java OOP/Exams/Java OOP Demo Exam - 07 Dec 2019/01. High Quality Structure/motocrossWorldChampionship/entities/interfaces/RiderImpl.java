package motocrossWorldChampionship.entities.interfaces;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_NAME;
import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_INVALID;

public  class RiderImpl implements Rider {
    private String name;
    private  Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate=false;

    public RiderImpl(String name) {
        setName(name);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
                if (motorcycle==null){
                    throw new NullPointerException(MOTORCYCLE_INVALID);
                }
    }

    @Override
    public void winRace() {
     this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        if (motorcycle!=null){
         this.canParticipate=true;
        }
        return false;
    }

    public void setName(String name) {
        if (this.name==null||this.name.trim().length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name,5));
        }
        this.name = name;
    }
}
