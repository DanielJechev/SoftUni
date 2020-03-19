package com.product.shop.domain.dtos.views.successfullySoldProducts;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserModel {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
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
