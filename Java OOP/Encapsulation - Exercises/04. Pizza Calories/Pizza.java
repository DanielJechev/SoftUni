package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name,int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        this.toppings=new ArrayList<>(numberOfToppings);

    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()||name.length()<1||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }



    public void setDough(Dough dough) {
        this.dough = dough;
    }


    private void setToppings(int numberOfToppings) {
        if (numberOfToppings<0||numberOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }
    public  void addTopping (Topping topping){
        toppings.add(topping);
    }
    private double getOverallCalories (){
        double result=0;
        result=this.dough.calculateCalories()+this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        return result;

    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",this.name,this.getOverallCalories());
    }
}
