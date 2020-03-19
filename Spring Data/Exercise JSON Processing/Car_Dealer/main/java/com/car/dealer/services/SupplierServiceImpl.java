package com.car.dealer.services;

import com.car.dealer.domain.dtos.bindings.SupplierDto;
import com.car.dealer.domain.entities.Supplier;
import com.car.dealer.domain.dtos.views.LocalSupplier;
import com.car.dealer.repositories.SupplierRepository;
import com.car.dealer.services.base.SupplierService;
import com.car.dealer.utils.GsonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final GsonUtil gsonUtil;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, GsonUtil gsonUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gsonUtil = gsonUtil;
    }


    @Override
    public void seedSuppliers(SupplierDto[] suppliersDto) {
        Supplier[] suppliers = this.modelMapper.map(suppliersDto, Supplier[].class);
        Arrays.stream(suppliers).forEach(this.supplierRepository::saveAndFlush);
    }

    @Override
    public void getAllSuppliersThatDoNotImportPartsFromAbroad() throws IOException {
        LocalSupplier[] customers = this.supplierRepository.getAllSuppliersThatDoNotImportPartsFromAbroad()
                .toArray(new LocalSupplier[0]);
        this.gsonUtil.saveJSONtoFile("local-suppliers", customers);
    }
}
