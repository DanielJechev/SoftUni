package com.car.dealer.controllers;

import com.car.dealer.domain.dtos.bindings.*;
import com.car.dealer.services.base.*;
import com.car.dealer.utils.base.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public Terminal(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, JaxbUtil jaxbUtil) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        this.saleService.getSalesByDiscount();
    }

    private void seedData() throws IOException, JAXBException {
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.saleService.seedSales();

    }

    private void seedCustomers() throws IOException, JAXBException {
        CustomersDto customersDto = this.jaxbUtil.unmarshXML("customers", CustomersDto.class);
        this.customerService.seedCustomers(customersDto);
    }

    private void seedCars() throws IOException, JAXBException {
        CarsDto carsDto = this.jaxbUtil.unmarshXML("cars", CarsDto.class);
        this.carService.seedCars(carsDto);
    }

    private void seedParts() throws IOException, JAXBException {
        PartsDto partsDto = this.jaxbUtil.unmarshXML("parts", PartsDto.class);
        this.partService.seedParts(partsDto);
    }

    private void seedSuppliers() throws IOException, JAXBException {
        SuppliersDto suppliersDto = this.jaxbUtil.unmarshXML("suppliers", SuppliersDto.class);
        this.supplierService.seedSuppliers(suppliersDto);
    }
}
