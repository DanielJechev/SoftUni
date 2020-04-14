package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        StringBuilder sb = new StringBuilder();
        List<Category> categoryList = this.categoryRepository.findAllByItemsCount();

        for (Category category : categoryList) {
            sb.append(String.format("Category: %s",category.getName())).append(System.lineSeparator());
            for (Item item : category.getItems()) {
                sb.append(String.format("--- Item Name: %s",item.getName())).append(System.lineSeparator())
                .append(String.format("--- Item Price: %s",item.getPrice())).append(System.lineSeparator())
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
