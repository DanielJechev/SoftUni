package rabbits;

public class Rabbit {
    private  static  final  boolean RATE_DEFAULT_VALUE=true;
    private  String name;
    private  String species;
    private boolean available=RATE_DEFAULT_VALUE;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s",this.getSpecies(),this.getName());
    }
}
