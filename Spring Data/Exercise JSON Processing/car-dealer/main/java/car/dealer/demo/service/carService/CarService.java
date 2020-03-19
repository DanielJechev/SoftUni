package car.dealer.demo.service.carService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.CarSeedDataBindingModel;
import car.dealer.demo.model.dto.viewModel.query2Dtos.CarDto;
import car.dealer.demo.model.dto.viewModel.query4.CarViewModel;
import car.dealer.demo.model.entity.Car;

import java.util.List;

public interface CarService {

    void saveAll(CarSeedDataBindingModel[] carDtos);

    Car oneById(Long carID);

    List<CarDto> getAllByMake(String make);

    List<CarViewModel> getAllCarsWithListOfParts();

}
