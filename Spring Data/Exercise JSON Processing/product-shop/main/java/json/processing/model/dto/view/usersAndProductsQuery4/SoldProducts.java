package json.processing.model.dto.view.usersAndProductsQuery4;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SoldProducts {

    @Expose
    private Long count;
    @Expose
    private List<ProductModels> products;

    public SoldProducts() {
    }

    public SoldProducts(Long count, List<ProductModels> products) {
        this.count = count;
        this.products = products;
    }

    public Long getCount() {
        this.count = (long)products.size();
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<ProductModels> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModels> products) {
        this.products = products;
    }
}
