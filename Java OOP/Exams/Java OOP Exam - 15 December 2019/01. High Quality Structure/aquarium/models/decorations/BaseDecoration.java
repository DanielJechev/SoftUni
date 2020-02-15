package aquarium.models.decorations;

public abstract class BaseDecoration implements Decoration {
    private int comfort;
    private double price;

    public BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }

    @Override
    public int getComfort() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
