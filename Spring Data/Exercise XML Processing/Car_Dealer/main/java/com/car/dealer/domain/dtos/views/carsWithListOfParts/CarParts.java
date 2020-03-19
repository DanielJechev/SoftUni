package com.car.dealer.domain.dtos.views.carsWithListOfParts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarParts {
    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private List<PartModel> parts;

    public CarParts() {
    }

    public CarParts(String make, String model, Long travelledDistance, List<PartModel> parts) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.parts = parts;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartModel> getParts() {
        return parts;
    }

    public void setParts(List<PartModel> parts) {
        this.parts = parts;
    }
}
