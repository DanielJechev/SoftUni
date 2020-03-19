package com.product.shop.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column
    @Size(min = 3, max = 15, message = "Category name must be between 3 and 15 characters.")
    @NotNull(message = "Name is required.")
    private String name;

    @ManyToMany(mappedBy = "categories", targetEntity = Product.class)
    private Set<Product> products;

    public Category() {
    }

    public Category(@Size(min = 3, max = 15, message = "Category name must be between 3 and 15 characters.") String name) {
        this.name = name;
        this.products = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
