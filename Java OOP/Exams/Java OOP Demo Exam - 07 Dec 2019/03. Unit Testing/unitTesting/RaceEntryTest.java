package unitTesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class RaceEntryTest {
@Test(expected = NullPointerException.class)
    public void addRiderException(){
    RaceEntry raceEntry=new RaceEntry();
    raceEntry.addRider(null);
}
    @Test(expected = IllegalArgumentException.class)
    public void addRiderExceptionName(){
        RaceEntry raceEntry=new RaceEntry();
        UnitRider unitRider1=new UnitRider("asd",new UnitMotorcycle("asda",100,200));
        UnitRider unitRider2=new UnitRider("asd",new UnitMotorcycle("asdaf",100,200));
        raceEntry.addRider(unitRider1);
        raceEntry.addRider(unitRider2);
    }
    @Test
    public void addRider(){
        RaceEntry raceEntry=new RaceEntry();
        UnitRider unitRider1=new UnitRider("asd",new UnitMotorcycle("asda",100,200));
        UnitRider unitRider2=new UnitRider("asd1",new UnitMotorcycle("asdaf",100,200));
        raceEntry.addRider(unitRider1);
        raceEntry.addRider(unitRider2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerException(){
        RaceEntry raceEntry=new RaceEntry();
        UnitRider unitRider1=new UnitRider("asd",new UnitMotorcycle("asda",100,200));
        raceEntry.addRider(unitRider1);
        raceEntry.calculateAverageHorsePower();
    }
    @Test()
    public void calculateAverage(){
        RaceEntry raceEntry=new RaceEntry();
        UnitRider unitRider1=new UnitRider("asda",new UnitMotorcycle("asda",100,200));
        UnitRider unitRider=new UnitRider("asdb",new UnitMotorcycle("asda",200,200));
        UnitRider unitRider2=new UnitRider("asdaf",new UnitMotorcycle("asda",300,200));
        raceEntry.addRider(unitRider);
        raceEntry.addRider(unitRider1);
        raceEntry.addRider(unitRider2);
Assert.assertEquals(200,raceEntry.calculateAverageHorsePower(),20.00);
    }

    @Test
    public  void getRidersShould(){
        RaceEntry heroRepository=new RaceEntry();
        Collection<UnitRider> riders=heroRepository.getRiders();
        boolean isUnmodifiableCollection=false;
        try {
            riders.add(new UnitRider("asd",new UnitMotorcycle("sdv",100,20)));

        }catch (Exception ex){
            isUnmodifiableCollection=true;
        }
        Assert.assertTrue(isUnmodifiableCollection);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void  getRidersShouldThrowException(){
        RaceEntry heroRepository=new RaceEntry();
        Collection<UnitRider> riders=heroRepository.getRiders();
        riders.clear();
    }


}
