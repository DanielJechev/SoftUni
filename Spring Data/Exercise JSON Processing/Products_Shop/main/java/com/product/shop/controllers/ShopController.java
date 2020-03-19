package com.product.shop.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.product.shop.domain.dtos.bindings.CategoryDto;
import com.product.shop.domain.dtos.bindings.ProductDto;
import com.product.shop.domain.dtos.bindings.UserDto;
import com.product.shop.services.base.CategoryService;
import com.product.shop.services.base.ProductService;
import com.product.shop.services.base.UserService;
import com.product.shop.utils.base.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ShopController implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;
    private final Gson gson;

    @Autowired
    public ShopController(UserService userService, ProductService productService, CategoryService categoryService, FileUtil fileUtil) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers()
                .setPrettyPrinting()
                .create();
    }


    @Override
    public void run(String... args) throws Exception {
        this.userService.getUsersWithProducts();
    }

    private void seedDatabase() throws IOException {
        this.seedUsers();
        this.seedProducts();
        this.seedCategories();
        this.productService.seedProductsWithCategory();
    }

    private void seedCategories() throws IOException {
        String categoriesStr = this.fileUtil.readContent("categories");
        CategoryDto[] categoriesDto = this.gson.fromJson(categoriesStr, CategoryDto[].class);
        this.categoryService.saveCategories(categoriesDto);
    }

    private void seedProducts() throws IOException {
        String productsStr = this.fileUtil.readContent("products");
        ProductDto[] productsDto = this.gson.fromJson(productsStr, ProductDto[].class);
        this.productService.saveProducts(productsDto);
    }

    private void seedUsers() throws IOException {
        String usersStr = this.fileUtil.readContent("users");
        UserDto[] usersDto = this.gson.fromJson(usersStr, UserDto[].class);
        this.userService.saveUsers(usersDto);
    }
}
