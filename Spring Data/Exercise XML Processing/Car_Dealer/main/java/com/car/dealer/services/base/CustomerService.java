package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.CustomersDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CustomerService {
    void seedCustomers(CustomersDto customersDto);

    void getAllCustomersOrderByBirthDate() throws IOException, JAXBException;

    void getCustomersByTotalSalary() throws IOException, JAXBException;
}
