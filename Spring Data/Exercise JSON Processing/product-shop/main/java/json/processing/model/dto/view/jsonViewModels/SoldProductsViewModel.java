package json.processing.model.dto.view.jsonViewModels;

import com.google.gson.annotations.Expose;
import json.processing.model.entity.User;

import javax.persistence.Transient;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsViewModel implements Serializable{

    @Expose
    @XmlElement
    private String name;
    @Expose
    @XmlElement
    private BigDecimal price;
    @Expose
    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;
    @Expose
    @XmlElement(name = "buyer-last-name")
    private String buyerLastName;

    @XmlTransient
    private User buyer;

    public SoldProductsViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBuyerFirstName() {
        return this.buyer.getFirstName();
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return this.buyer.getLastName();
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
