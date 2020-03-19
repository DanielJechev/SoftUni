package com.car.dealer.domain.dtos.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersDto {
    @XmlElement(name = "customer")
    private List<CustomerDto> customersDto;

    public CustomersDto() {
    }

    public List<CustomerDto> getCustomersDto() {
        return customersDto;
    }

    public void setCustomersDto(List<CustomerDto> customersDto) {
        this.customersDto = customersDto;
    }
}
