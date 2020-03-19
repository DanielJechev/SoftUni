package com.product.shop.domain.dtos.views.usersAndProducts;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class ProductCount {
    @Expose
    private long count;

    @Expose
    private Set<ProductModel> products;

    public ProductCount() {
    }

    public ProductCount(long count, Set<ProductModel> products) {
        this.count = count;
        this.products = products;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }
}
