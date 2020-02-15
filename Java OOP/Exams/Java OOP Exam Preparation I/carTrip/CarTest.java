package carTrip;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void constructor(){
        Car car=new Car("bmw",200.00,100.00,400.00);
        assertEquals("bmw",car.getModel());
        assertEquals(200.00,car.getTankCapacity(),100);
        assertEquals(100.00,car.getFuelAmount(),100);
        assertEquals(400.00,car.getFuelConsumptionPerKm(),100);
    }
    @Test(expected =IllegalArgumentException.class)
    public void firstSetModelException(){
        Car car=new Car("bmw",200.00,100.00,400.00);
car.setModel(null);
    }
    @Test(expected =IllegalArgumentException.class)
    public void secondSetModelException(){
        Car car=new Car("bmw",200.00,100.00,400.00);
        car.setModel("");
    }
    @Test
    public void setModel(){
        Car car=new Car("bmw",200.00,100.00,400.00);
        car.setModel("bmw");
        assertEquals("bmw",car.getModel());
    }

    @Test
    public void setTankCapacity(){
        Car car=new Car("bmw",200.00,100.00,400.00);
        car.setTankCapacity(200.00);
          assertEquals(200.00,car.getTankCapacity(),200);
    }
@Test(expected = IllegalArgumentException.class)
    public void setFuelAmountException(){
    Car car=new Car("bmw",100.00,200.00,400.00);
    car.setFuelAmount(200.00);
}
    @Test
    public void setFuelAmount(){
        Car car=new Car("bmw",200.00,100.00,400.00);
        car.setFuelAmount(100.00);
        assertEquals(100.00,car.getFuelAmount(),200);
    }
@Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmException(){
    Car car=new Car("bmw",200.00,100.00,0);
    car.setFuelConsumptionPerKm(0);
}
    @Test
    public void setFuelConsumptionPerKm(){
        Car car=new Car("bmw",200.00,100.00,100.00);
        car.setFuelConsumptionPerKm(100.00);
        assertEquals(100.00,car.getFuelConsumptionPerKm(),100);
    }
    @Test(expected = IllegalStateException.class)
    public void driveException(){
        Car car=new Car("bmw",200.00,100.00,100.00);
        car.drive(1000.00);
    }
    @Test
    public void drive(){
        Car car=new Car("bmw",200.00,100.00,5.00);
        car.drive(10.00);
        double expected=car.getFuelAmount()-(10.00*car.getFuelConsumptionPerKm());
        assertEquals(50.00,car.getFuelAmount(),40);
    }
    @Test
    public void driveMessage(){
        Car car=new Car("bmw",200.00,100.00,5.00);
        car.drive(10.00);
        assertEquals(car.drive(10.00),"Have a nice trip");
    }

    @Test(expected = IllegalStateException.class)
    public void refuelException(){
        Car car=new Car("bmw",200.00,100.00,5.00);
        car.refuel(500.00);
    }
    @Test
    public void refuel(){
        Car car=new Car("bmw",200.0,100.00,5.00);
        car.refuel(10);
        assertEquals(car.getFuelAmount()+10,car.getFuelAmount(),100);
    }
}