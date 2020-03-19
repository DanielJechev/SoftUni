package com.product.shop.services.base;

import com.product.shop.domain.dtos.bindings.CategoriesDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CategoryService {
    void saveCategories(CategoriesDto categoriesDto);

    void saveCategoriesByProductsCount() throws IOException, JAXBException;
}
