package com.car.dealer.domain.dtos.views.orderCustomers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersOrder {
    @XmlElement(name = "customer")
    private List<CustomerOrders> customers;

    public CustomersOrder() {
    }

    public List<CustomerOrders> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerOrders> customers) {
        this.customers = customers;
    }
}
