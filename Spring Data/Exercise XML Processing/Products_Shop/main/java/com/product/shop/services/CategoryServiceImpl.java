package com.product.shop.services;

import com.product.shop.domain.dtos.bindings.CategoriesDto;
import com.product.shop.domain.dtos.views.categoriesByProductsCount.CategoriesModel;
import com.product.shop.domain.entities.Category;
import com.product.shop.domain.dtos.views.categoriesByProductsCount.CategoryModel;
import com.product.shop.repositories.CategoryRepository;
import com.product.shop.services.base.CategoryService;
import com.product.shop.utils.base.JaxbUtil;
import com.product.shop.utils.base.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, JaxbUtil jaxbUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void saveCategories(CategoriesDto categoriesDto) {
        Category[] categories = this.modelMapper.map(categoriesDto.getCategoryDtoList(), Category[].class);
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
    public void saveCategoriesByProductsCount() throws IOException, JAXBException {
        List<CategoryModel> categories = this.categoryRepository.getCategoriesByProductsCount();
        CategoriesModel categoriesModel = new CategoriesModel();
        categoriesModel.setCategoryModels(categories);
        this.jaxbUtil.saveToXML("categories-by-products", categoriesModel);
    }
}
