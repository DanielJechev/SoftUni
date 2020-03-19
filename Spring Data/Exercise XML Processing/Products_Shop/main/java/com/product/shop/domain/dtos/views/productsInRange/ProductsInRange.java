package com.product.shop.domain.dtos.views.productsInRange;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRange {
    @XmlElement(name = "product")
    private List<ProductInRange> products;

    public ProductsInRange() {
    }

    public List<ProductInRange> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRange> products) {
        this.products = products;
    }
}
