package aquarium.models.fish;

public  abstract  class BaseFish implements Fish {
    private String name;
    private String species;
    private  int size;
    private  double price;

    public BaseFish(String name, String species, int size ,double price) {
        this.name = name;
        this.species = species;
     this.size=size;
        this.price = price;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void eat() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
