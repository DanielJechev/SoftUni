package vehicle;

import java.text.DecimalFormat;


public class Car extends Vehicles {

    private static final double CLIMATIC_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }
}
