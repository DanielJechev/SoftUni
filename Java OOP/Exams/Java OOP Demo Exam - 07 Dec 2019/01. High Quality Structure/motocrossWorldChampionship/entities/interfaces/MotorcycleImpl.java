package motocrossWorldChampionship.entities.interfaces;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_MODEL;

public abstract   class MotorcycleImpl implements Motorcycle {
    private String model;
    private int horsePower;
    private double 	cubicCentimeters;

    public MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        this.horsePower=horsePower;
        this.cubicCentimeters=cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    public void setModel(String model) {
        if (this.model==null||this.model.trim().length()<4) {
        throw new IllegalArgumentException(String.format(INVALID_MODEL ,model,4));
        }

            this.model = model;

    }



    @Override
    public double calculateRacePoints(int laps) {
        double result=(this.cubicCentimeters/this.horsePower)/laps;
        return result;
    }
}
