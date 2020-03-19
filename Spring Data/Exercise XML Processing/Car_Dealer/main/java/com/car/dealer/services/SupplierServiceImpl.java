package com.car.dealer.services;

import com.car.dealer.domain.dtos.bindings.SuppliersDto;
import com.car.dealer.domain.dtos.views.localSupplier.LocalSuppliers;
import com.car.dealer.domain.entities.Supplier;
import com.car.dealer.domain.dtos.views.localSupplier.LocalSupplier;
import com.car.dealer.repositories.SupplierRepository;
import com.car.dealer.services.base.SupplierService;
import com.car.dealer.utils.base.JaxbUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, JaxbUtil jaxbUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void seedSuppliers(SuppliersDto suppliersDto) {
        Supplier[] suppliers = this.modelMapper.map(suppliersDto.getSuppliers(), Supplier[].class);
        Arrays.stream(suppliers).forEach(this.supplierRepository::saveAndFlush);
    }

    @Override
    public void getAllSuppliersThatDoNotImportPartsFromAbroad() throws IOException, JAXBException {
        LocalSupplier[] suppliers = this.supplierRepository.getAllSuppliersThatDoNotImportPartsFromAbroad()
                .toArray(new LocalSupplier[0]);

        LocalSuppliers localSuppliers = new LocalSuppliers();
        localSuppliers.setSuppliers(Arrays.asList(suppliers));
        this.jaxbUtil.saveToXML("local-suppliers", localSuppliers);
    }
}
