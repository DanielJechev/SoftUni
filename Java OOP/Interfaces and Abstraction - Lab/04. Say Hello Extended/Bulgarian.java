package hello;

public class Bulgarian extends BasePerson implements Person {
    protected Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
