package com.car.dealer.domain.dtos.views.localSupplier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSuppliers implements Serializable {
    @XmlElement(name = "supplier")
    private List<LocalSupplier> suppliers;

    public LocalSuppliers() {
    }

    public List<LocalSupplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<LocalSupplier> suppliers) {
        this.suppliers = suppliers;
    }
}
