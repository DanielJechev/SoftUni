package car.dealer.demo.model.dto.viewModel.query6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleQuery6Wrapper {

    @XmlElement(name = "sale")
    private List<SaleViewModelQuery6> viewModelQuery6s;

    public SaleQuery6Wrapper() {
    }

    public SaleQuery6Wrapper(List<SaleViewModelQuery6> viewModelQuery6s) {
        this.viewModelQuery6s = viewModelQuery6s;
    }

    public List<SaleViewModelQuery6> getViewModelQuery6s() {
        return viewModelQuery6s;
    }

    public void setViewModelQuery6s(List<SaleViewModelQuery6> viewModelQuery6s) {
        this.viewModelQuery6s = viewModelQuery6s;
    }
}
