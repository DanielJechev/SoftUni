package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant( String name) {
        this.data = new ArrayList<>();
        this.name = name;
    }
    public  void add(Salad salad){
        this.data.add(salad);
    }
    public  boolean buy(String name){
        Salad saladToRemove = null;
        for (Salad salad : data) {
            if (salad.getName().equals(name)) {
                saladToRemove = salad;
                break;
            }
        }
        if (saladToRemove != null) {
            this.data.remove(saladToRemove);
            return true;
        }
        return false;
    }
    public  Salad getHealthiestSalad(){
        int minCalories = Integer.MAX_VALUE;
        Salad salad = null;
        for (Salad s : data) {
            if (s.getTotalCalories() < minCalories) {
                minCalories = s.getTotalCalories();
                salad = s;
            }
        }
        return salad;

    }
    public  String generateMenu(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s have %d salads:",
                this.name,
                this.data.size()))
                .append(System.lineSeparator());

        for (Salad s : data) {
            sb.append(s).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
