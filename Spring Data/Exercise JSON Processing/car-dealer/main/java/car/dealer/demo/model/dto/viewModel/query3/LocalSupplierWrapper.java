package car.dealer.demo.model.dto.viewModel.query3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierWrapper {

    @XmlElement(name = "supplier")
    private List<LocalSupplierDto> supplierDtos;

    public LocalSupplierWrapper() {
    }

    public LocalSupplierWrapper(List<LocalSupplierDto> supplierDtos) {
        this.supplierDtos = supplierDtos;
    }

    public List<LocalSupplierDto> getSupplierDtos() {
        return supplierDtos;
    }

    public void setSupplierDtos(List<LocalSupplierDto> supplierDtos) {
        this.supplierDtos = supplierDtos;
    }
}
