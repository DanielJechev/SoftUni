package com.car.dealer.domain.dtos.views.customerSales;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersBySales implements Serializable {
    @XmlElement(name = "customer")
    private List<CustomerBySales> customers;

    public CustomersBySales() {
    }

    public List<CustomerBySales> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerBySales> customers) {
        this.customers = customers;
    }
}
