package com.car.dealer.domain.dtos.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDto implements Serializable {
    @XmlAttribute
    private String name;

    @XmlAttribute(name = "is-importer")
    private Boolean isImporter;

    public SupplierDto() {
    }

    public SupplierDto(String name, Boolean isImported) {
        this.name = name;
        this.isImporter = isImported;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}
