package com.company;

public class Reservation {
    private  double pricePerDay;
    private  int   days;
    private  Season season;
    private  Discount discountType;

    public Reservation(double pricePerDay, int days, Season season, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getDays() {
        return days;
    }

    public Season getSeason() {
        return season;
    }

    public Discount getDiscountType() {
        return discountType;
    }
}
