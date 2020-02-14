package com.company;

public class PriceCalculator {
    public static double calculate(Reservation reservation){
        double price=reservation.getPricePerDay()*reservation.getDays()*reservation.getSeason().getCode();
        double percent=1-(reservation.getDiscountType().getCode()/100.0);
        return price*percent;
    }
}
