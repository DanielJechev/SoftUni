package com.car.dealer.domain.dtos.views;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CustomerBySales {
    @Expose
    private String fullName;

    @Expose
    private int boughtCars;

    @Expose
    private BigDecimal spentMoney;

    public CustomerBySales() {
    }

    public CustomerBySales(String fullName, int boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
