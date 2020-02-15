package motocrossWorldChampionship.common;

public class ExceptionMessages {
    public static final String INVALID_MODEL = "Model %s cannot be less than %d symbols.";

    public static final String INVALID_NAME = "Name %s cannot be less than %d symbols.";

    public static final String INVALID_HORSE_POWER = "Invalid horse power: %d.";

    public static final String INVALID_NUMBER_OF_LAPS = "Laps cannot be less than %d.";


    public static final String RIDER_EXISTS = "Rider %s is already created.";

    public static final String RIDER_ALREADY_ADDED = "Rider %s is already added in %s race.";

    public static final String RIDER_NOT_FOUND = "Rider %s could not be found.";

    public static final String RIDER_NOT_PARTICIPATE = "Rider %s could not participate in race.";

    public static final String RIDER_INVALID = "Rider cannot be null.";


    public static final String MOTORCYCLE_EXISTS = "Motorcycle %s is already create.";

    public static final String MOTORCYCLE_INVALID = "Motorcycle cannot be null.";

    public static final String MOTORCYCLE_NOT_FOUND = "Motorcycle %s could not be found.";


    public static final String RACE_NOT_FOUND = "Race %s could not be found.";

    public static final String RACE_EXISTS = "Race %s is already created.";

    public static final String RACE_INVALID = "Race %s cannot start with less than %d participants.";
}
