package car.dealer.demo.service.customerService;

import car.dealer.demo.model.dto.bindingModel.query1Dtos.SaleDto;
import car.dealer.demo.model.dto.bindingModel.seedDataDtos.CustomerSeedDataBindinModel;
import car.dealer.demo.model.dto.viewModel.query1.CustomerViewModelQuery1;
import car.dealer.demo.model.dto.viewModel.query5.CustomerViewModelQuery5;
import car.dealer.demo.model.entity.Customer;
import car.dealer.demo.model.entity.Sale;
import car.dealer.demo.repository.CustomerRepository;
import car.dealer.demo.utils.modelMapper.DtoConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveAll(CustomerSeedDataBindinModel[] customerDtos) {
        Arrays.stream(customerDtos)
                .map(c -> DtoConvertUtil.convert(c, Customer.class))
                .forEach(this.customerRepository::saveAndFlush);
    }

    @Override
    public Customer oneById(Long customerID) {
        return this.customerRepository.getOne(customerID);
    }

    @Override
    public List<CustomerViewModelQuery1> allOrderedByBirthDate() {
        List<Customer> orderedCustomers =
                this.customerRepository.getAllByOrderByBirthDateAscYoungDriverDesc();

        List<CustomerViewModelQuery1> viewModel =
                orderedCustomers.stream().map(c -> {
                    CustomerViewModelQuery1 model = new CustomerViewModelQuery1();
                    model.setId(c.getId());
                    model.setName(c.getName());
                    model.setBirthDate(c.getBirthDate());
                    model.setYoungDriver(c.isYoungDriver());

                    Set<SaleDto> saleDto = new HashSet<>();
                    c.getSales().stream().forEach(s -> {
                        SaleDto dto = new SaleDto();
                        dto.setId(s.getId());
                        saleDto.add(dto);
                    });
                    model.setSales(saleDto);
                    return model;
                }).collect(Collectors.toList());

//        List<CustomerViewModelQuery1> viewModel =
//                DtoConvertUtil.convert(orderedCustomers, CustomerViewModelQuery1.class);

        return viewModel;
    }

    @Override
    public List<CustomerViewModelQuery5> getAllWithMinOneBoughtCar() {
        List<Customer> customerList = this.customerRepository.getAllWithMinOneBoughtCar();
        List<CustomerViewModelQuery5> viewModel =
                customerList.stream().map(c -> {
                    CustomerViewModelQuery5 model = new CustomerViewModelQuery5();
                    model.setFullName(c.getName());
                    model.setBoughtCars(c.getSales().size());
                    model.setSpentMoney(getSpendMoney(c));
                    return model;
                }).collect(Collectors.toList());
        return viewModel;
    }

    private BigDecimal getSpendMoney(Customer c) {
        BigDecimal spendMoney = BigDecimal.ZERO;

        for (Sale sale : c.getSales()) {
            double discount = sale.getDiscount() / 100.0;
            BigDecimal finalDiscount = BigDecimal.valueOf(discount);
            BigDecimal moneyDiscount = sale.getCar().getPrice().multiply(finalDiscount);
            spendMoney = spendMoney.add(sale.getCar().getPrice().subtract(moneyDiscount));
        }

        return spendMoney;
    }

}
