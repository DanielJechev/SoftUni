package car.dealer.demo.model.dto.viewModel.query4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarViewModelWrapper {

    @XmlElement(name = "car")
    private List<CarViewModel> carViewModels;

    public CarViewModelWrapper() {
    }

    public CarViewModelWrapper(List<CarViewModel> carViewModels) {
        this.carViewModels = carViewModels;
    }

    public List<CarViewModel> getCarViewModels() {
        return carViewModels;
    }

    public void setCarViewModels(List<CarViewModel> carViewModels) {
        this.carViewModels = carViewModels;
    }
}
