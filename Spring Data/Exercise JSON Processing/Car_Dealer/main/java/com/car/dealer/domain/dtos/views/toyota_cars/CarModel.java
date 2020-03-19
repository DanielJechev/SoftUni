package com.car.dealer.domain.dtos.views.toyota_cars;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CarModel implements Serializable {
    @Expose
    private int id;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;

    public CarModel() {
    }

    public CarModel(int id, String make, String model, Long travelledDistance) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
