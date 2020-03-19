package json.processing.model.dto.view.jsonViewModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldItemViewModel implements Serializable{

    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;
    @Expose
    @SerializedName("soldProducts")
    @XmlElementWrapper(name = "sold-products")
    private Set<SoldProductsViewModel> sellingProducts;

    public UserWithSoldItemViewModel() {
        this.sellingProducts = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<SoldProductsViewModel> getSellingProducts() {
        return sellingProducts;
    }

    public void setSellingProducts(Set<SoldProductsViewModel> sellingProducts) {
        this.sellingProducts = sellingProducts;
    }
}
