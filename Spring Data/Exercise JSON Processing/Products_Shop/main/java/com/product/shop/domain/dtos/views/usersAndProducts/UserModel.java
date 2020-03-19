package com.product.shop.domain.dtos.views.usersAndProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class UserModel {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    private Set<ProductModel> soldProducts;

    @Expose
    @SerializedName("soldProducts")
    private ProductCount sold;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, int age, Set<ProductModel> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<ProductModel> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductModel> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public ProductCount getSold() {
        return sold;
    }

    public void setSold(ProductCount sold) {
        this.sold = sold;
    }
}
