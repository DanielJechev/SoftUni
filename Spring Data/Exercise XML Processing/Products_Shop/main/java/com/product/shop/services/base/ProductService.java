package com.product.shop.services.base;

import com.product.shop.domain.dtos.bindings.ProductsDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface ProductService {
    void saveProducts(ProductsDto productsDto);

    void seedProductsWithCategory();

    void saveProductsInRange() throws IOException, JAXBException;

    void saveSuccessfullySoldProducts() throws IOException, JAXBException;
}
