package car.dealer.demo.service.customerService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.CustomerSeedDataBindinModel;
import car.dealer.demo.model.dto.viewModel.query1.CustomerViewModelQuery1;
import car.dealer.demo.model.dto.viewModel.query5.CustomerViewModelQuery5;
import car.dealer.demo.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    void saveAll(CustomerSeedDataBindinModel[] customerDtos);

    Customer oneById(Long customerID);

    List<CustomerViewModelQuery1> allOrderedByBirthDate();

    List<CustomerViewModelQuery5> getAllWithMinOneBoughtCar();
}
