package com.car.dealer.domain.dtos.views.order_customers;

import com.google.gson.annotations.Expose;

public class SaleOrders {
    @Expose
    private Integer discount;

    @Expose
    private CarOrders car;

    public SaleOrders() {
    }

    public SaleOrders(Integer discount, CarOrders car) {
        this.discount = discount;
        this.car = car;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public CarOrders getCar() {
        return car;
    }

    public void setCar(CarOrders car) {
        this.car = car;
    }
}
