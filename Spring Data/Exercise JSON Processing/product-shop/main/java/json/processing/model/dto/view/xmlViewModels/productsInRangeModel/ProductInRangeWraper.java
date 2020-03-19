package json.processing.model.dto.view.xmlViewModels.productsInRangeModel;

import json.processing.model.dto.view.jsonViewModels.ProductInRangeViewModel;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeWraper {

    @XmlElement(name = "product")
    List<ProductInRangeViewModel> viewModels;

    public ProductInRangeWraper() {
    }

    public List<ProductInRangeViewModel> getViewModels() {
        return viewModels;
    }

    public void setViewModels(List<ProductInRangeViewModel> viewModels) {
        this.viewModels = viewModels;
    }
}
