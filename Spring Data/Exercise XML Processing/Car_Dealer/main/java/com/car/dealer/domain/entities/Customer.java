package com.car.dealer.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    @Column
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "is_young_driver")
    private Boolean isYoungDriver;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class, fetch = FetchType.EAGER)
    private Set<Sale> sales;

    public Customer() {
    }

    public Customer(String name, Date birthDate, Boolean isYoungDriver) {
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
