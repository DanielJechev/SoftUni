package json.processing.model.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class    UserWithSoldItemViewModel implements Serializable{

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    @SerializedName("soldProducts")
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
