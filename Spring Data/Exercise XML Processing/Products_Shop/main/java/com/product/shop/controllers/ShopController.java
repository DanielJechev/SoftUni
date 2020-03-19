package com.product.shop.controllers;

import com.product.shop.domain.dtos.bindings.CategoriesDto;
import com.product.shop.domain.dtos.bindings.ProductsDto;
import com.product.shop.domain.dtos.bindings.UsersDto;
import com.product.shop.services.base.CategoryService;
import com.product.shop.services.base.ProductService;
import com.product.shop.services.base.UserService;
import com.product.shop.utils.base.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Component
public class ShopController implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public ShopController(UserService userService, ProductService productService, CategoryService categoryService, JaxbUtil jaxbUtil) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.getUsersWithProducts();
    }

    private void seedDatabase() throws IOException, JAXBException {
        this.seedUsers();
        this.seedProducts();
        this.seedCategories();
        this.productService.seedProductsWithCategory();
    }

    private void seedCategories() throws IOException, JAXBException {
        CategoriesDto categoriesDto = this.jaxbUtil.unmarshXML("categories", CategoriesDto.class);
        this.categoryService.saveCategories(categoriesDto);
    }

    private void seedProducts() throws IOException, JAXBException {
        ProductsDto productsDto = this.jaxbUtil.unmarshXML("products", ProductsDto.class);
        this.productService.saveProducts(productsDto);
    }

    private void seedUsers() throws IOException, JAXBException {
        UsersDto usersDto = this.jaxbUtil.unmarshXML("users", UsersDto.class);
        this.userService.saveUsers(usersDto);
    }
}
