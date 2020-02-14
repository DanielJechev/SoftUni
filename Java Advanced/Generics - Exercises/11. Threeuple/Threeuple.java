package Jar;


public class Threeuple<item1,item2,item3> {
    private item1 item1;
    private item2 item2;
    private item3 item3;

    public Threeuple(item1 item1, item2 item2, item3 item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s",this.item1,this.item2,this.item3);
    }
}
