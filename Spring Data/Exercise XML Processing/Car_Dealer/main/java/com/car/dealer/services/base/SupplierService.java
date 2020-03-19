package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.SuppliersDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SupplierService {
    void seedSuppliers(SuppliersDto suppliersDto);

    void getAllSuppliersThatDoNotImportPartsFromAbroad() throws IOException, JAXBException;
}
