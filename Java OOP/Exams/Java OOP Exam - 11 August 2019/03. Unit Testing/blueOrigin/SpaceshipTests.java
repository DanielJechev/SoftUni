package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    @Test(expected = IllegalArgumentException.class)
    public  void addException(){
        Spaceship spaceship=new Spaceship("asd",10);
        Astronaut astronaut=new Astronaut("ASF",10);

        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
    @Test(expected = IllegalArgumentException.class)
    public  void addEx(){
        Spaceship spaceship=new Spaceship("asd",1);
        Astronaut astronaut=new Astronaut("ASF",10);
        Astronaut astronaut1=new Astronaut("ASF1",10);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }
    @Test
    public  void add(){
        Spaceship spaceship=new Spaceship("asd",2);
        Astronaut astronaut=new Astronaut("van",13.00);
        Astronaut astronaut1=new Astronaut("vafn",133.00);
        spaceship.add(astronaut1);
        spaceship.add(astronaut);
        Assert.assertEquals(2,spaceship.getCount());
    }


@Test
    public void  remove(){
    Spaceship spaceship=new Spaceship("asd",10);
    Astronaut astronaut=new Astronaut("ASF1",10);
    Astronaut astronaut1=new Astronaut("ASF",10);
    spaceship.add(astronaut);
    spaceship.add(astronaut1);
    spaceship.remove("ASF");
    Assert.assertEquals(1,spaceship.getCount());
}
    @Test(expected = IllegalArgumentException.class)
    public void  capacityException(){
        Spaceship spaceship=new Spaceship("asd",-1);
        Astronaut astronaut=new Astronaut("ASF1",10);
        Astronaut astronaut1=new Astronaut("ASF",10);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);

    }
    @Test(expected = NullPointerException.class)
    public void  nameException(){
        Spaceship spaceship=new Spaceship("",100);
        Astronaut astronaut=new Astronaut("ASF1",10);
        Astronaut astronaut1=new Astronaut("ASF",10);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);

    }
    @Test(expected = NullPointerException.class)
    public void  nameExceptionNull(){
        Spaceship spaceship=new Spaceship(null,100);
        Astronaut astronaut=new Astronaut("ASF1",10);
        Astronaut astronaut1=new Astronaut("ASF",10);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);

    }
}
