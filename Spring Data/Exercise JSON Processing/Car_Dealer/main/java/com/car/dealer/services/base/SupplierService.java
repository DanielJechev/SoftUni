package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.SupplierDto;

import java.io.IOException;

public interface SupplierService {
    void seedSuppliers(SupplierDto[] suppliersDto);

    void getAllSuppliersThatDoNotImportPartsFromAbroad() throws IOException;
}
