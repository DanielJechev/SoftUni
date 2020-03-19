package car.dealer.demo.model.dto.bindingModel.seedDataDtos;

public class SaleSeedBindingModel {

    private Long carID;
    private Long customerID;
    private double discount;

    public SaleSeedBindingModel() {
    }

    public SaleSeedBindingModel(Long carID, Long customerID, double discount) {
        this.carID = carID;
        this.customerID = customerID;
        this.discount = discount;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
