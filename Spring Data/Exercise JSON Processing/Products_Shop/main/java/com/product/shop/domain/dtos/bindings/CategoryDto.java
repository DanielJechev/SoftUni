package com.product.shop.domain.dtos.bindings;

public class CategoryDto {
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
