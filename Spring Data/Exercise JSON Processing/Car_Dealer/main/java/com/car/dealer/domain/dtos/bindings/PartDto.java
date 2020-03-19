package com.car.dealer.domain.dtos.bindings;

import java.io.Serializable;
import java.math.BigDecimal;

public class PartDto implements Serializable {
    private String name;

    private BigDecimal price;

    private Double quantity;

    public PartDto() {
    }

    public PartDto(String name, BigDecimal price, Double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
