package com.car.dealer.domain.dtos.views.localSupplier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplier implements Serializable {
    @XmlAttribute
    private int id;

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "parts-count")
    private int partsCount;

    public LocalSupplier() {
    }

    public LocalSupplier(int id, String name, int partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
