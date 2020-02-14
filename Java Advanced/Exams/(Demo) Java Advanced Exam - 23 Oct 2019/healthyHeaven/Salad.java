package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad( String name) {
        this.products = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  int getTotalCalories(){
        return this.products.stream()
                .map(Vegetable::getCalories)
                .mapToInt(Integer::intValue)
                .sum();
    }
    public  int getProductCount(){
        return this.products.size();
    }
    public void add(Vegetable vegetable){
        this.products.add(vegetable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount()))
                .append(System.lineSeparator());

        for (Vegetable v : products) {
            sb.append(v.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    }

