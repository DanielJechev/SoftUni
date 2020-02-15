package motocrossWorldChampionship.entities.interfaces;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static  final  int horse_Power=50;
    private static  final  int horse_Power1=69;
    private static  final   int cubic_Centimeters=450;

    public SpeedMotorcycle(String model, int horsePower, double cubicCentimeters) {
        super(model, setHorsePower(horsePower), cubic_Centimeters);

    }


    private static  int setHorsePower(int horsePower){
        if (horsePower<horse_Power||horsePower>horse_Power1){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        return horsePower;
    }

}