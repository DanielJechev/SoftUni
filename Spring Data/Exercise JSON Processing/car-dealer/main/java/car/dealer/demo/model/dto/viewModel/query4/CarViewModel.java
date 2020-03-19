package car.dealer.demo.model.dto.viewModel.query4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarViewModel {

    @Expose
    @SerializedName(value = "Make")
    @XmlAttribute
    private String make;

    @Expose
    @SerializedName(value = "Model")
    @XmlAttribute
    private String model;

    @Expose
    @SerializedName(value = "TravelledDistance")
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @Expose
    @XmlElementWrapper(name = "parts")
    private List<PartViewModel> parts;

    public CarViewModel() {
    }

    public CarViewModel(String make, String model, Long travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        parts = new ArrayList<>();
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartViewModel> getParts() {
        return parts;
    }

    public void setParts(List<PartViewModel> parts) {
        this.parts = parts;
    }
}

