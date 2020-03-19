package json.processing.model.dto.binding.jsonBindingModels;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductCreateBindingModel implements Serializable {
    private String name;
    private BigDecimal price;
    private Integer buyer;
    private Integer seller;

    public ProductCreateBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBuyer() {
        return this.buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public Integer getSeller() {
        return this.seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }
}
