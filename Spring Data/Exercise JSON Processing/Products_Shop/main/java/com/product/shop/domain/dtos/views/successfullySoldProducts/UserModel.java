package com.product.shop.domain.dtos.views.successfullySoldProducts;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserModel {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Set<ProductModel> soldProducts;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, Set<ProductModel> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductModel> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductModel> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
