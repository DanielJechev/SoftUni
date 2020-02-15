package farm;

public abstract  class Food {
private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
