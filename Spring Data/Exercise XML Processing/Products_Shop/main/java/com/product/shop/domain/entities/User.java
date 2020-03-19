package com.product.shop.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String firstName;

    @Column
    @NotNull(message = "Last name is required.")
    @Size(min = 3, message = "Last name must be at least 3 characters.")
    private String lastName;

    @Column
    private int age;

    @OneToMany(mappedBy = "buyer", targetEntity = Product.class)
    private Set<Product> purchaseProducts;

    @OneToMany(mappedBy = "seller", targetEntity = Product.class, fetch = FetchType.EAGER)
    private Set<Product> soldProducts;

    @ManyToMany
    @JoinTable(name = "users_friends",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    public User() {
    }

    public User(String firstName, @Size(min = 3, message = "Last name must be at least 3 characters.") String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.purchaseProducts = new HashSet<>();
        this.soldProducts = new HashSet<>();
        this.friends = new HashSet<>();
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

    public Set<Product> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void setPurchaseProducts(Set<Product> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }

    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
