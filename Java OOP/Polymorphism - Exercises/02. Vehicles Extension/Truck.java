package vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicles {

    private static final double CLIMATIC_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }


    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
