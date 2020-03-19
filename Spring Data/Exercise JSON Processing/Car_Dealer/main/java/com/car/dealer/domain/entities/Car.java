package com.car.dealer.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column
    private String make;

    @Column
    private String model;

    @Column(name = "travelled_distance")
    private Long travelledDistance;

    @OneToOne(mappedBy = "car", targetEntity = Sale.class)
    private Sale sale;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "parts_carts",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    private Set<Part> parts;

    public Car() {
    }

    public Car(String make, String model, Long travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
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

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
