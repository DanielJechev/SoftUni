package json.processing.model.dto.binding.jsonBindingModels;

import json.processing.model.dto.view.jsonViewModels.UserViewModel;

import java.math.BigDecimal;

public class ProductBindingModel {

    private String name;
    private BigDecimal price;
    private UserViewModel seller;
    private UserViewModel buyer;

    public ProductBindingModel() {
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

    public UserViewModel getSeller() {
        return seller;
    }

    public void setSeller(UserViewModel seller) {
        this.seller = seller;
    }

    public UserViewModel getBuyer() {
        return buyer;
    }

    public void setBuyer(UserViewModel buyer) {
        this.buyer = buyer;
    }

}
