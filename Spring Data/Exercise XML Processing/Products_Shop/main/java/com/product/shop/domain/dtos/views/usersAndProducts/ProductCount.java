package com.product.shop.domain.dtos.views.usersAndProducts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProductCount {
    @XmlAttribute
    private long count;

    @XmlElement(name = "product")
    private List<ProductModel> products;

    public ProductCount() {
    }

    public ProductCount(long count, List<ProductModel> products) {
        this.count = count;
        this.products = products;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
