package car.dealer.demo.service.saleService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.SaleSeedBindingModel;
import car.dealer.demo.model.dto.viewModel.query6.SaleViewModelQuery6;

import java.util.List;

public interface SaleService {

    void saveAll(List<SaleSeedBindingModel> salesList);

    List<SaleViewModelQuery6> salesWithAppliedDiscount();
}
