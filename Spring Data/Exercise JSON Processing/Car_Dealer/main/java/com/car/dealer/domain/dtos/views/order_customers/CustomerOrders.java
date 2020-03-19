package com.car.dealer.domain.dtos.views.order_customers;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.Set;

public class CustomerOrders {
    @Expose
    private String name;

    @Expose
    private Date birthDate;

    @Expose
    private Boolean isYoungDriver;

    @Expose
    private Set<SaleOrders> sales;

    public CustomerOrders() {
    }

    public CustomerOrders(String name, Date birthDate, Boolean isYoungDriver, Set<SaleOrders> sales) {
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
        this.sales = sales;
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

    public Set<SaleOrders> getSales() {
        return sales;
    }

    public void setSales(Set<SaleOrders> sales) {
        this.sales = sales;
    }
}
