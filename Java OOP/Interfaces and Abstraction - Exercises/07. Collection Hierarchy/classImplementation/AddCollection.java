package classImplementation;

import interfaces.Addable;

public class AddCollection  extends  Collection implements Addable {

    @Override
    public int add(String s) {
        super.getItems().add(0,s);
        return 0;
    }
}
