package car.dealer.demo.model.dto.viewModel.query6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleViewModelQuery6 {

    @Expose
    @XmlElement
    private CarViewModelQuery6 car;
    @Expose
    @XmlElement(name = "customer-name")
    private String customerName;
    @Expose
    @SerializedName("Discount")
    @XmlElement
    private Double discount;
    @Expose
    @XmlElement
    private BigDecimal price;
    @Expose
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleViewModelQuery6() {
    }

    public CarViewModelQuery6 getCar() {
        return car;
    }

    public void setCar(CarViewModelQuery6 car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
