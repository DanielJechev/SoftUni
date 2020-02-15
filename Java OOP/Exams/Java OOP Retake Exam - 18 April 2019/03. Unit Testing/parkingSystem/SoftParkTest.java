package parkingSystem;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SoftParkTest {

     @Test
    public  void testConstructorSize(){
    SoftPark softPark=new SoftPark();
    Assert.assertEquals(12,softPark.getParking().size());
}
@Test(expected = IllegalArgumentException.class)
public  void parkCarExceptionFirst(){
         SoftPark softPark=new SoftPark();
         Car car=new Car("bmw","as");
         softPark.parkCar("ad",car);
}

    @Test(expected = IllegalArgumentException.class)
    public  void parkCarExceptionSecond(){
        SoftPark softPark=new SoftPark();
        Car car=new Car("bmw","as");
        softPark.parkCar("A1",car);
        softPark.parkCar("A1",car);
    }
    @Test
    public  void parkCarMessage(){
        SoftPark softPark=new SoftPark();
        Car car=new Car("bmw","as");
        softPark.parkCar("A1",car);
        String expected=String.format("Car:%s parked successfully!",car.getRegistrationNumber());
        Assert.assertEquals(expected,"Car:as parked successfully!");
    }
    @Test(expected = IllegalArgumentException.class)
public void removeExceptionFirst(){
        SoftPark softPark=new SoftPark();
        Car car=new Car("bmw","as");
        softPark.removeCar("as",car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeExceptionSecond(){
        SoftPark softPark=new SoftPark();
        Car car=new Car("bmw","as");
        
        softPark.removeCar("A1",new Car("adfd","saafd"));
    }

}