package com.product.shop.domain.dtos.views;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductInRange {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String seller;

    public ProductInRange() {
    }

    public ProductInRange(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
