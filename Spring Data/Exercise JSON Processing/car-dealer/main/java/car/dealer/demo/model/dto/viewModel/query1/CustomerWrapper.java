package car.dealer.demo.model.dto.viewModel.query1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWrapper {

    @XmlElement(name = "customer")
    private List<CustomerViewModelQuery1> customers;

    public CustomerWrapper() {
    }

    public CustomerWrapper(List<CustomerViewModelQuery1> customers) {
        this.customers = customers;
    }

    public List<CustomerViewModelQuery1> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerViewModelQuery1> customers) {
        this.customers = customers;
    }
}
