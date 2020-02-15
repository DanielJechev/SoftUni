package motocrossWorldChampionship.core.interfaces;

public interface ChampionshipController {
    String createRider(String riderName);

    String createMotorcycle(String type, String model, int horsePower);

    String addMotorcycleToRider(String riderName, String motorcycleModel);

    String addRiderToRace(String raceName, String riderName);

    String startRace(String raceName);

    String createRace(String name, int laps);
}
