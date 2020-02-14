package define;

public class Citizen implements Identifiable,Birthable {
    private String name;
    private  int age;
    private String id;
    private String birthDate;


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }


    public String getName() {
        return this.name;
    }


    public int getAge() {
        return this.age;
    }

@Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }


}
