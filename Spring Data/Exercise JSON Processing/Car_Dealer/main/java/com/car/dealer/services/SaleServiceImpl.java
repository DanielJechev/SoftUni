package com.car.dealer.services;

import com.car.dealer.domain.entities.Car;
import com.car.dealer.domain.entities.Customer;
import com.car.dealer.domain.entities.Sale;
import com.car.dealer.domain.dtos.views.salesWithDiscount.CarDiscount;
import com.car.dealer.domain.dtos.views.salesWithDiscount.SaleModel;
import com.car.dealer.repositories.CarRepository;
import com.car.dealer.repositories.CustomerRepository;
import com.car.dealer.repositories.SaleRepository;
import com.car.dealer.services.base.SaleService;
import com.car.dealer.utils.GsonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final int START_SEED_COUNT_CAR = 100;
    private final int SALES_SEED_COUNT = 30;
    private final Integer[] DISCOUNTS = { 0, 5, 10, 15, 20, 30, 40, 50 };

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final Random random;
    private final ModelMapper modelMapper;
    private final GsonUtil gsonUtil;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, ModelMapper modelMapper, Random random, GsonUtil gsonUtil) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.random = random;
        this.modelMapper = modelMapper;
        this.gsonUtil = gsonUtil;
    }

    @Override
    public void seedSales() {
        Car[] cars = this.carRepository.findAll().toArray(new Car[0]);
        Customer[] customers = this.customerRepository.findAll().toArray(new Customer[0]);


        for (int i = START_SEED_COUNT_CAR; i < START_SEED_COUNT_CAR + SALES_SEED_COUNT; i++) {
            int randomCustomerIndex = this.random.nextInt(customers.length);
            int randomDiscountIndex = this.random.nextInt(DISCOUNTS.length);

            Sale sale = new Sale(DISCOUNTS[randomDiscountIndex], cars[i], customers[randomCustomerIndex]);
            this.saleRepository.save(sale);
        }
    }

    @Override
    public void getSalesByDiscount() throws IOException {
        List<SaleModel> salesByDiscount = this.saleRepository.getSalesByDiscount();
        salesByDiscount.forEach(s -> s.setCarModel(this.modelMapper.map(s.getCar(), CarDiscount.class)));
        this.gsonUtil.saveJSONtoFile("sales-discounts", salesByDiscount.toArray(new SaleModel[0]));
    }
}
