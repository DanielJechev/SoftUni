package car.dealer.demo.service.saleService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.SaleSeedBindingModel;
import car.dealer.demo.model.dto.viewModel.query6.CarViewModelQuery6;
import car.dealer.demo.model.dto.viewModel.query6.SaleViewModelQuery6;
import car.dealer.demo.model.entity.Car;
import car.dealer.demo.model.entity.Customer;
import car.dealer.demo.model.entity.Sale;
import car.dealer.demo.repository.SaleRepository;
import car.dealer.demo.service.carService.CarService;
import car.dealer.demo.service.customerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository,
                           CarService carService,
                           CustomerService customerService) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public void saveAll(List<SaleSeedBindingModel> salesList) {
        List<Sale> saleList = new ArrayList<>();
        salesList.forEach(s -> {
            Car car = carService.oneById(s.getCarID());
            Customer customer = customerService.oneById(s.getCustomerID());
            Sale sale = new Sale(car, customer, s.getDiscount());
            saleList.add(sale);
        });
        this.saleRepository.saveAll(saleList);
    }

    @Override
    public List<SaleViewModelQuery6> salesWithAppliedDiscount() {
        List<Sale> sales = this.saleRepository.findAll();
        List<SaleViewModelQuery6> viewModels =
                sales.stream().map(s -> {
                    SaleViewModelQuery6 model = new SaleViewModelQuery6();
                    model.setCar(getCarViewModel(s));
                    model.setCustomerName(s.getCustomer().getName());
                    double discount = s.getDiscount() / 100.0;
                    model.setDiscount(discount);
                    model.setPrice(s.getCar().getPrice());
                    model.setPriceWithDiscount(getPriceWithDiscount(s, discount));
                    return model;
                }).collect(Collectors.toList());

        return viewModels;
    }

    private BigDecimal getPriceWithDiscount(Sale s, double d) {
        BigDecimal discountPercent = BigDecimal.valueOf(d);
        BigDecimal carPrice = s.getCar().getPrice();
        BigDecimal discountMoney = s.getCar().getPrice().multiply(discountPercent);

        return carPrice.subtract(discountMoney);
    }

    private CarViewModelQuery6 getCarViewModel(Sale s) {
        CarViewModelQuery6 carModel = new CarViewModelQuery6();
        carModel.setMake(s.getCar().getMake());
        carModel.setModel(s.getCar().getModel());
        carModel.setTravelledDistance(s.getCar().getTravelledDistance());
        return carModel;
    }
}
