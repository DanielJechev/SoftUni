package json.processing.service.productService;

import json.processing.model.dto.binding.jsonBindingModels.ProductCreateBindingModel;
import json.processing.model.dto.binding.xmlBindingModels.seedProductsBindingModels.ProductsSeedDataWrapper;
import json.processing.model.dto.view.jsonViewModels.ProductInRangeViewModel;
import json.processing.model.dto.view.jsonViewModels.UserWithSoldItemViewModel;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    void persist(Collection<ProductCreateBindingModel> models);

    List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to);

    List<UserWithSoldItemViewModel> getAllUsersQuery2();

    void persistAllProducts(ProductsSeedDataWrapper productWrapper);
}
