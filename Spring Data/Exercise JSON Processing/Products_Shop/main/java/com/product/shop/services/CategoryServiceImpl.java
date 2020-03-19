package com.product.shop.services;

import com.product.shop.domain.dtos.bindings.CategoryDto;
import com.product.shop.domain.entities.Category;
import com.product.shop.domain.dtos.views.categoriesByProductsCount.CategoryModel;
import com.product.shop.repositories.CategoryRepository;
import com.product.shop.services.base.CategoryService;
import com.product.shop.utils.base.GsonUtil;
import com.product.shop.utils.base.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final GsonUtil gsonUtil;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, GsonUtil gsonUtil, ValidatorUtil validatorUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gsonUtil = gsonUtil;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void saveCategories(CategoryDto[] categoriesDto) {
        Category[] categories = this.modelMapper.map(categoriesDto, Category[].class);
        Arrays.stream(categories).forEach(c -> {
            List<String> violationsMessage = validatorUtil.getViolationsMessage(c);

            if (violationsMessage.size() > 0) {
                violationsMessage.forEach(System.out::println);
            } else {
                this.categoryRepository.save(c);
            }
        });
    }

    @Override
    public void saveCategoriesByProductsCount() throws IOException {
        List<CategoryModel> categories = this.categoryRepository.getCategoriesByProductsCount();
        CategoryModel[] categoryModelsArr = categories.toArray(new CategoryModel[0]);
        this.gsonUtil.saveJSONtoFile("categories-by-products", categoryModelsArr);
    }
}
