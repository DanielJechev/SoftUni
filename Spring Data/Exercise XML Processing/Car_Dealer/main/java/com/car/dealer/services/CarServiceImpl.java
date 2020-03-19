package com.car.dealer.services;

import com.car.dealer.domain.dtos.bindings.CarsDto;
import com.car.dealer.domain.dtos.views.carsWithListOfParts.CarsParts;
import com.car.dealer.domain.dtos.views.toyotaCars.CarsModel;
import com.car.dealer.domain.entities.Car;
import com.car.dealer.domain.entities.Part;
import com.car.dealer.domain.dtos.views.carsWithListOfParts.CarParts;
import com.car.dealer.domain.dtos.views.toyotaCars.CarModel;
import com.car.dealer.repositories.CarRepository;
import com.car.dealer.repositories.PartRepository;
import com.car.dealer.services.base.CarService;
import com.car.dealer.utils.base.JaxbUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Random random;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper modelMapper, Random random, JaxbUtil jaxbUtil) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.random = random;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void seedCars(CarsDto carsDto) {
        Car[] cars = this.modelMapper.map(carsDto.getCars(), Car[].class);
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
    public void findAllCarsByMakeOrderByModelThenByDistance() throws IOException, JAXBException {
        List<CarModel> toyotaCars = this.carRepository.findAllCarsByMakeOrderByModelThenByDistance("Toyota");
        CarsModel cars = new CarsModel();
        cars.setCars(toyotaCars);
        this.jaxbUtil.saveToXML("toyota-cars", cars);
    }

    @Override
    public void getCarWithParts() throws IOException, JAXBException {
        List<Car> cars = this.carRepository.findAll();
        CarParts[] carPartsModel = this.modelMapper.map(cars, CarParts[].class);
        CarsParts carsParts = new CarsParts();
        carsParts.setCarParts(Arrays.asList(carPartsModel));
        this.jaxbUtil.saveToXML("cars-and-parts", carsParts);
    }
}
