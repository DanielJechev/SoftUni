package classImplementation;

import interfaces.MyList;

public class MyListImpl extends Collection implements MyList {


    @Override
    public int getUsed() {
        return super.getItems().size();
    }

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
