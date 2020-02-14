package chicken;

public class Chicken {
    private String name;
    private  int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length()<=0){
            throw  new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
     if (age<=0||age>15){
         throw new IllegalArgumentException("Age should be between 0 and 15.");
     }
        this.age = age;
    }
    public double productPerDay (){
        double eggs=0;
        if (this.age<6){
            eggs=2;
        }else if (this.age>=6 && this.age<12){
            eggs=1;
        }else {
          eggs=0.75;
        }
        return eggs;
    }
    private double calculateProductPerDay(){
        double result=0;
        result=productPerDay()*this.age;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %f eggs per day.",name,age,productPerDay());
    }
}
