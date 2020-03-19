package com.car.dealer.domain.dtos.views.salesWithDiscount;

import com.car.dealer.domain.entities.Car;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class SaleModel implements Serializable {
    @XmlTransient
    private Car car;

    @XmlElement(name = "car")
    private CarDiscount carModel;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement
    private Double discount;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleModel() {
    }

    public SaleModel(Car car, String customerName, Integer discount, BigDecimal price) {
        this.car = car;
        this.customerName = customerName;
        this.discount = discount / 100d;
        this.price = price;
        this.priceWithDiscount = this.price.multiply(BigDecimal.valueOf(1 - this.discount));
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
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
