package car.dealer.demo.model.dto.viewModel.query2Dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWrapper {

    @XmlElement(name = "car")
    private List<CarDto> carDtos;

    public CarWrapper() {
    }

    public CarWrapper(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    public void setCarDtos(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }
}
