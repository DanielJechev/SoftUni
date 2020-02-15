package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    @Test(expected = NullPointerException.class)
    public void checkNameException() {
        Aquarium aquarium = new Aquarium(null, 100);

    }

    @Test(expected = NullPointerException.class)
    public void checkNameException1() {
        Aquarium aquarium = new Aquarium("", 100);

    }


    @Test(expected = IllegalArgumentException.class)
    public void checkCapacityException() {
        Aquarium aquarium = new Aquarium("asd", -1);
    }
    @Test
    public void checkCapacity() {

        Aquarium aquarium = new Aquarium("asd", 100);
        Assert.assertEquals(100,aquarium.getCapacity());
    }
    @Test
    public void checkName() {
        Aquarium aquarium = new Aquarium("asd", 100);
        Assert.assertEquals("asd",aquarium.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void addException() {
        Aquarium aquarium = new Aquarium("asdfg", 1);
        Fish fish =new Fish("asd");
        Fish fish1 =new Fish("asd1");
        aquarium.add(fish);
        aquarium.add(fish1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void removeException() {
        Aquarium aquarium = new Aquarium("afsd", 10);
        Fish fish =new Fish("asd");
        aquarium.add(fish);
        aquarium.remove("asd");
        aquarium.remove("asd");
    }
    @Test
    public void remove() {
        Aquarium aquarium = new Aquarium("afsd", 10);
        Fish fish =new Fish("asd");
        Fish fish1 =new Fish("as1d");
        aquarium.add(fish);
        aquarium.add(fish1);
        aquarium.remove("asd");
        Assert.assertEquals(1,aquarium.getCount());
    }
    @Test
    public void add() {
        Aquarium aquarium = new Aquarium("asd", 10);
        Fish fish =new Fish("asdf");
        Fish fish1 =new Fish("as1d");
        aquarium.add(fish);
        aquarium.add(fish1);

        Assert.assertEquals(2,aquarium.getCount());
    }





    @Test(expected = IllegalArgumentException.class)
    public void sellFish() {
        Aquarium aquarium = new Aquarium("n", 10);
        Fish fish =new Fish("asd1");
        Fish fish1 =new Fish("asd2");
        Fish fish2 =new Fish("asd3");
        aquarium.add(fish);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.sellFish("b");
    }
    @Test
    public void tdoString(){
        Aquarium aquarium = new Aquarium("asd", 10);
        Fish fish2 =new Fish("asd3");
        aquarium.add(fish2);
        String expected= String.format("Fish available at %s: %s", aquarium.getName(), fish2.getName());;
        Assert.assertEquals(expected,aquarium.report());

    }
    @Test
    public void sellFishT() {
        Aquarium aquarium = new Aquarium("n", 10);
        Fish fish =new Fish("asd1");
        Fish fish1 =new Fish("asd2");
        Fish fish2 =new Fish("asd3");
        aquarium.add(fish);
        aquarium.add(fish1);
        aquarium.add(fish2);
        Assert.assertEquals(aquarium.sellFish("asd1"),fish);

    }


}