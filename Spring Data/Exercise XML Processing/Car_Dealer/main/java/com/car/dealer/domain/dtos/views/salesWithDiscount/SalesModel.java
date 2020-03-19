package com.car.dealer.domain.dtos.views.salesWithDiscount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesModel implements Serializable {
    @XmlElement(name = "sale")
    private List<SaleModel> sales;

    public SalesModel() {
    }

    public List<SaleModel> getSales() {
        return sales;
    }

    public void setSales(List<SaleModel> sales) {
        this.sales = sales;
    }
}
