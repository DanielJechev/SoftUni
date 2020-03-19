package com.car.dealer.services;

import com.car.dealer.domain.dtos.bindings.CarDto;
import com.car.dealer.domain.entities.Car;
import com.car.dealer.domain.entities.Part;
import com.car.dealer.domain.dtos.views.carsWithListOfParts.CarParts;
import com.car.dealer.domain.dtos.views.toyota_cars.CarModel;
import com.car.dealer.repositories.CarRepository;
import com.car.dealer.repositories.PartRepository;
import com.car.dealer.services.base.CarService;
import com.car.dealer.utils.GsonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Random random;
    private final GsonUtil gsonUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper modelMapper, Random random, GsonUtil gsonUtil) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.random = random;
        this.gsonUtil = gsonUtil;
    }

    @Override
    public void seedCars(CarDto[] carsDto) {
        Car[] cars = this.modelMapper.map(carsDto, Car[].class);
        Part[] parts = this.partRepository.findAll().toArray(new Part[0]);
        int partsCount = parts.length;

        for (Car car : cars) {
            int numberOfParts = this.random.nextInt(11) + 10;
            Set<Part> partsForCurrentCar = new HashSet<>();

            for (int i = 0; i < numberOfParts; i++) {
                int randomPartIndex = this.random.nextInt(partsCount);
                partsForCurrentCar.add(parts[randomPartIndex]);
            }

            car.setParts(partsForCurrentCar);
            this.carRepository.saveAndFlush(car);
        }

    }

    @Override
    public void findAllCarsByMakeOrderByModelThenByDistance() throws IOException {
        List<CarModel> toyotaCars = this.carRepository.findAllCarsByMakeOrderByModelThenByDistance("Toyota");
        this.gsonUtil.saveJSONtoFile("toyota-cars", toyotaCars.toArray(new CarModel[0]));
    }

    @Override
    public void getCarWithParts() throws IOException {
        List<Car> cars = this.carRepository.findAll();
        CarParts[] carPartsModel = this.modelMapper.map(cars, CarParts[].class);
        this.gsonUtil.saveJSONtoFile("cars-and-parts", carPartsModel);
    }
}
