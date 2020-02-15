package aquarium.models.fish;

import aquarium.common.ExceptionMessages;

public  abstract  class BaseFish implements Fish {
    private String name;
    private String species;
    private  int size;
    private  double price;

    public BaseFish(String name, String species, int size ,double price) {
        setName(name);
        setSpecies(species);
     this.size=size;
        setPrice(price);
    }

    @Override
    public void setName(String name) {
if (name==null||name.trim().isEmpty()){
    throw new NullPointerException(ExceptionMessages.FISH_NAME_NULL_OR_EMPTY);
}
    }

    @Override
    public void eat() {

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setSpecies(String species) {
        if (species==null||species.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    public void setPrice(double price) {
        if (price<0){
            throw new IllegalArgumentException(ExceptionMessages.FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }
}
