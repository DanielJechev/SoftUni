package alararestaurant.domain.dtos.jsons;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ItemImportDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String category;

    public ItemImportDto(){}

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
