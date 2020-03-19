package car.dealer.demo.model.dto.viewModel.query5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerQuery5Wrapper {

    @XmlElement(name = "customer")
    private List<CustomerViewModelQuery5> viewModelQuery5s;

    public CustomerQuery5Wrapper() {
    }

    public CustomerQuery5Wrapper(List<CustomerViewModelQuery5> viewModelQuery5s) {
        this.viewModelQuery5s = viewModelQuery5s;
    }

    public List<CustomerViewModelQuery5> getViewModelQuery5s() {
        return viewModelQuery5s;
    }

    public void setViewModelQuery5s(List<CustomerViewModelQuery5> viewModelQuery5s) {
        this.viewModelQuery5s = viewModelQuery5s;
    }
}
