package com.car.dealer.domain.dtos.views.carsWithListOfParts;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarParts {
    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;

    @Expose
    private Set<PartModel> parts;

    public CarParts() {
    }

    public CarParts(String make, String model, Long travelledDistance, Set<PartModel> parts) {
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

    public Set<PartModel> getParts() {
        return parts;
    }

    public void setParts(Set<PartModel> parts) {
        this.parts = parts;
    }
}
