package com.product.shop.domain.dtos.views.usersAndProducts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserModel {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private int age;

    @XmlTransient
    private List<ProductModel> soldProducts;

    @XmlElement(name = "sold-products")
    private ProductCount sold;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, int age, List<ProductModel> soldProducts) {
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

    public List<ProductModel> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductModel> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public ProductCount getSold() {
        return sold;
    }

    public void setSold(ProductCount sold) {
        this.sold = sold;
    }
}
