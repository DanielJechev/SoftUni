package com.car.dealer.controllers;

import com.car.dealer.domain.dtos.bindings.CarDto;
import com.car.dealer.domain.dtos.bindings.CustomerDto;
import com.car.dealer.domain.dtos.bindings.PartDto;
import com.car.dealer.domain.dtos.bindings.SupplierDto;
import com.car.dealer.services.base.*;
import com.car.dealer.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;
    private final FileUtil fileUtil;

    @Autowired
    public Terminal(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, FileUtil fileUtil) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.fileUtil = fileUtil;
        this.gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
                .create();
    }

    @Override
    public void run(String... args) throws Exception {
        this.carService.getCarWithParts();
    }

    private void seedData() throws IOException {
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.saleService.seedSales();

    }

    private void seedCustomers() throws IOException {
        String customersStr = this.fileUtil.readContent("customers");
        CustomerDto[] customersDto = this.gson.fromJson(customersStr, CustomerDto[].class);
        this.customerService.seedCustomers(customersDto);
    }

    private void seedCars() throws IOException {
        String cars = this.fileUtil.readContent("cars");
        CarDto[] carsDto = this.gson.fromJson(cars, CarDto[].class);
        this.carService.seedCars(carsDto);
    }

    private void seedParts() throws IOException {
        String parts = this.fileUtil.readContent("parts");
        PartDto[] partsDto = this.gson.fromJson(parts, PartDto[].class);
        this.partService.seedParts(partsDto);
    }

    private void seedSuppliers() throws IOException {
        String suppliers = this.fileUtil.readContent("suppliers");
        SupplierDto[] suppliersDto = this.gson.fromJson(suppliers, SupplierDto[].class);
        this.supplierService.seedSuppliers(suppliersDto);
    }
}
