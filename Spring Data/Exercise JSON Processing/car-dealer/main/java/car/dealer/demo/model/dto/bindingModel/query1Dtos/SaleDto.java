package car.dealer.demo.model.dto.bindingModel.query1Dtos;

import car.dealer.demo.model.entity.Car;
import car.dealer.demo.model.entity.Customer;
import com.google.gson.annotations.Expose;

public class SaleDto {

    @Expose
    private Long id;
//    @Expose
//    private String car;
//    @Expose
//    private String customer;
//    @Expose
//    private double discount;

    public SaleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
//    public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(double discount) {
//        this.discount = discount;
//    }
//
//    public String getCar() {
//        return car;
//    }
//
//    public void setCar(String car) {
//        this.car = car;
//    }
//
//    public String getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(String customer) {
//        this.customer = customer;
//    }
}
