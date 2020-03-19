package com.car.dealer.domain.dtos.views;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class LocalSupplier implements Serializable {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
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
