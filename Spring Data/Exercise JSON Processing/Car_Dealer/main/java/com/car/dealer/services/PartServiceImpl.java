package com.car.dealer.services;

import com.car.dealer.domain.dtos.bindings.PartDto;
import com.car.dealer.domain.entities.Part;
import com.car.dealer.domain.entities.Supplier;
import com.car.dealer.repositories.PartRepository;
import com.car.dealer.repositories.SupplierRepository;
import com.car.dealer.services.base.PartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, ModelMapper modelMapper, Random random) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.random = random;
    }


    @Override
    public void seedParts(PartDto[] partsDto) {
        Part[] parts = this.modelMapper.map(partsDto, Part[].class);
        Supplier[] suppliers = this.supplierRepository.findAll().toArray(new Supplier[0]);
        int suppliersCount = suppliers.length;

        for (Part part : parts) {
            int randomSupplierIndex = this.random.nextInt(suppliersCount);
            part.setSupplier(suppliers[randomSupplierIndex]);
        }

        Arrays.stream(parts).forEach(this.partRepository::saveAndFlush);
    }
}
