package car.dealer.demo.service.supplierService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.SuppliersSeedDataBindingModel;
import car.dealer.demo.model.dto.viewModel.query3.LocalSupplierDto;
import car.dealer.demo.model.entity.Supplier;

import java.util.List;

public interface SupplierService {

    void saveAll(SuppliersSeedDataBindingModel[] suppliersDtos);

    Supplier findOneById(Long id);

    List<LocalSupplierDto> getAllLocalSuppliers();
}
