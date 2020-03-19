package com.car.dealer.domain.dtos.views.salesWithDiscount;

import com.car.dealer.domain.entities.Car;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class SaleModel {
    private Car car;

    @Expose
    @SerializedName("car")
    private CarDiscount carModel;

    @Expose
    private String customerName;

    @Expose
    private Integer discount;

    @Expose
    private BigDecimal price;

    @Expose
    private BigDecimal priceWithDiscount;

    public SaleModel() {
    }

    public SaleModel(Car car, String customerName, Integer discount, BigDecimal price) {
        this.car = car;
        this.customerName = customerName;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = this.price.multiply(BigDecimal.valueOf(1 - this.discount / 100d));
    }

    public CarDiscount getCarModel() {
        return carModel;
    }

    public void setCarModel(CarDiscount carModel) {
        this.carModel = carModel;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
