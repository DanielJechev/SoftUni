package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.CarDto;

import java.io.IOException;

public interface CarService {
    void seedCars(CarDto[] carsDto);

    void findAllCarsByMakeOrderByModelThenByDistance() throws IOException;

    void getCarWithParts() throws IOException;
}
