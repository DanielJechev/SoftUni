package motocrossWorldChampionship.entities.interfaces;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;


public class PowerMotorcycle extends   MotorcycleImpl {
    private  static  final  double cubic_centimeters=450;
    private  static final  int horsePowerMin=70;
    private  static final  int horsePowerMax=100;
    public PowerMotorcycle(String model, int horsePower) {
        super(model, setHorsePower(horsePower), cubic_centimeters);
    }
    private static int setHorsePower(int horsePower){
        if (horsePower<horsePowerMin||horsePower>horsePowerMax){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
    return horsePower;
    }

}
