package com.car.dealer.domain.dtos.views.carsWithListOfParts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsParts {
    @XmlElement(name = "car")
    private List<CarParts> carParts;

    public CarsParts() {
    }

    public List<CarParts> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarParts> carParts) {
        this.carParts = carParts;
    }
}
