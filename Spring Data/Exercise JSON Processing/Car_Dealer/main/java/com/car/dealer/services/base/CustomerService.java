package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.CustomerDto;

import java.io.IOException;

public interface CustomerService {
    void seedCustomers(CustomerDto[] customersDto);

    void getAllCustomersOrderByBirthDate() throws IOException;

    void getCustomersByTotalSalary() throws IOException;
}
