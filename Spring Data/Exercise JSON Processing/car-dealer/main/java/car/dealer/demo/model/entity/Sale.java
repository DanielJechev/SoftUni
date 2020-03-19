package car.dealer.demo.model.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {

    @Expose
    private Long id;
    @Expose
    private Car car;
    @Expose
    private Customer customer;
    @Expose
    private double discount;

    public Sale() {
    }

    public Sale(Car car, Customer customer, double discount) {
        this.car = car;
        this.customer = customer;
        this.discount = discount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
