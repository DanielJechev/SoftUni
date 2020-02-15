package motocrossWorldChampionship.entities.interfaces;

public interface Motorcycle {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}
