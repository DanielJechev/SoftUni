package classImplementation;

import interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {


    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size()-1);
    }

    @Override
    public int add(String s) {
        super.getItems().add(0,s);
        return 0;
    }
}
