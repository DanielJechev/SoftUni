package json.processing.model.dto.view.jsonViewModels.usersAndProductsQuery4;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sold-products")
public class SoldProducts {

    @Expose
    @XmlAttribute
    private Long count;
    @Expose
    @XmlElement(name = "products")
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
