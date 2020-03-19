package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.CarsDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CarService {
    void seedCars(CarsDto carsDto);

    void findAllCarsByMakeOrderByModelThenByDistance() throws IOException, JAXBException;

    void getCarWithParts() throws IOException, JAXBException;
}
