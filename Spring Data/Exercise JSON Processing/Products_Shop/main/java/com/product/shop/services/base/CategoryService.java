package com.product.shop.services.base;

import com.product.shop.domain.dtos.bindings.CategoryDto;

import java.io.IOException;

public interface CategoryService {
    void saveCategories(CategoryDto[] categoriesDto);

    void saveCategoriesByProductsCount() throws IOException;
}
