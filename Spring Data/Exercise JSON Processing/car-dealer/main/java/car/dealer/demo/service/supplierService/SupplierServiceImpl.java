package car.dealer.demo.service.supplierService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.SuppliersSeedDataBindingModel;
import car.dealer.demo.model.dto.viewModel.query3.LocalSupplierDto;
import car.dealer.demo.model.entity.Supplier;
import car.dealer.demo.repository.SupplierRepository;
import car.dealer.demo.utils.modelMapper.DtoConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void saveAll(SuppliersSeedDataBindingModel[] suppliersDtos) {
        Arrays.stream(suppliersDtos)
                .map(s -> DtoConvertUtil.convert(s, Supplier.class))
                .forEach(this.supplierRepository::saveAndFlush);
    }

    @Override
    public Supplier findOneById(Long id) {
        return this.supplierRepository.getOne(id);
    }

    @Override
    public List<LocalSupplierDto> getAllLocalSuppliers() {
        List<LocalSupplierDto> supplierDtos = this.supplierRepository.selectAllLocalSuppliers();
        return supplierDtos;
    }
}
