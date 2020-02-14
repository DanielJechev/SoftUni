package carShopExtend;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s sells for %f",getModel(),getPrice());
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
