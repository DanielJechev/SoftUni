package aquarium.models.fish;

public class FreshwaterFish extends BaseFish {
    private int size;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, 3, price);
    }
}
