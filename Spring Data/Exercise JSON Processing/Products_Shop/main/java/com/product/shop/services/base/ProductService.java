package com.product.shop.services.base;

import com.product.shop.domain.dtos.bindings.ProductDto;

import java.io.IOException;

public interface ProductService {
    void saveProducts(ProductDto[] productsDto);

    void seedProductsWithCategory();

    void saveProductsInRange() throws IOException;

    void saveSuccessfullySoldProducts() throws IOException;
}
