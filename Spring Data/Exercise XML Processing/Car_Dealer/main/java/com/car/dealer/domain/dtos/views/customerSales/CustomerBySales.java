package com.car.dealer.domain.dtos.views.customerSales;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerBySales implements Serializable {
    @XmlAttribute(name = "full-name")
    private String fullName;

    @XmlAttribute(name = "bought-cars")
    private int boughtCars;

    @XmlAttribute(name = "spent-money")
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
