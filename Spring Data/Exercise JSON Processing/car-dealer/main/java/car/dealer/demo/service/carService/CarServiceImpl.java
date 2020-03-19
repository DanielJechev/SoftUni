package car.dealer.demo.service.carService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.CarSeedDataBindingModel;
import car.dealer.demo.model.dto.viewModel.query2Dtos.CarDto;
import car.dealer.demo.model.dto.viewModel.query4.CarViewModel;
import car.dealer.demo.model.entity.Car;
import car.dealer.demo.model.entity.Part;
import car.dealer.demo.repository.CarRepository;
import car.dealer.demo.service.partService.PartService;
import car.dealer.demo.utils.modelMapper.DtoConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartService partService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          PartService partService) {
        this.carRepository = carRepository;
        this.partService = partService;
    }

    @Override
    public void saveAll(CarSeedDataBindingModel[] carDtos) {
        for (CarSeedDataBindingModel carDto : carDtos) {
            Car car = DtoConvertUtil.convert(carDto, Car.class);
            seedRandomParts(car);
            this.carRepository.saveAndFlush(car);
        }
    }

    @Override
    public Car oneById(Long carID) {
        return this.carRepository.getOne(carID);
    }

    @Override
    public List<CarDto> getAllByMake(String make) {
        List<CarDto> cars = this.carRepository.findAllByMakeOrderByModel(make);
        return cars;
    }

    @Override
    public List<CarViewModel> getAllCarsWithListOfParts() {
        List<Car> carList = this.carRepository.findAll();
        List<CarViewModel> viewModels = DtoConvertUtil.convert(carList, CarViewModel.class);
        return viewModels;
    }

    private void seedRandomParts(Car car) {
        List<Part> partsSet = new ArrayList<>();
        Random random = new Random();
        int partsCount;
        do {
            partsCount = random.nextInt(20);
        } while (partsCount < 10);

        for (int i = 1; i <= partsCount; i++) {
            int partID;
            do {
                partID = random.nextInt(131);
            } while (partID == 0);
            Part part = this.partService.getOneById((long) partID);
            partsSet.add(part);
        }
        String debug = "";
        car.setParts(partsSet);
    }
}
