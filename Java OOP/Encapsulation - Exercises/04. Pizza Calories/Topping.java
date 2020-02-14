package pizza;

public class Topping {
    private String toppingType;
    private  double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat")&&!toppingType.equals("Veggies")&&!toppingType.equals("Cheese")&&!toppingType.equals("Sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight<1||weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",toppingType));
        }
        this.weight = weight;
    }
    public double calculateCalories (){
       double result=this.weight*2;
       if (toppingType.equals("Meat")){
           result*=1.2;
       }
        if (toppingType.equals("Veggies")){
            result*=0.8;
        } if (toppingType.equals("Cheese")){
            result*=1.1;
        } if (toppingType.equals("Sauce")){
            result*=0.9;
        }


       return result;
    }
}
