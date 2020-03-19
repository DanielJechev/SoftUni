package json.processing.service.categoryService;

import json.processing.model.dto.binding.jsonBindingModels.CategoryBindingModel;
import json.processing.model.dto.binding.xmlBindingModels.seedCategoriesBindingModels.CategorySeedDataWrapper;
import json.processing.model.dto.view.jsonViewModels.CategoryByProductsCountViewModel;

import java.util.List;

public interface CategoryService {

    void persist(CategoryBindingModel categoryBindingModel);

    CategoryBindingModel getCategoryById(Long categoryID);

    List<CategoryByProductsCountViewModel> categoriesByProductCount();

    void persisAllCategories(CategorySeedDataWrapper categoryWrapper);
}
