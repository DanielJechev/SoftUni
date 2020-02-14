package dani;

public class GenericBox <E>{

    private E element ;

    public GenericBox(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.element.getClass().getName(),this.element);
    }
}
