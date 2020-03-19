package com.product.shop.domain.dtos.views.categoriesByProductsCount;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CategoryModel {
    @Expose
    private String category;

    @Expose
    private int productsCount;

    @Expose
    private Double averagePrice;

    @Expose
    private BigDecimal totalRevenue;

    public CategoryModel() {
    }

    public CategoryModel(String category, int productsCount, Double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
