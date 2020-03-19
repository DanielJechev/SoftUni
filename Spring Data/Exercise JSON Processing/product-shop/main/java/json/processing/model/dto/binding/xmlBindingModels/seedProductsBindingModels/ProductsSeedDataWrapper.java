package json.processing.model.dto.binding.xmlBindingModels.seedProductsBindingModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSeedDataWrapper {

    @XmlElement(name = "product")
    List<ProductSeedDataDto> productDtos;

    public ProductsSeedDataWrapper() {
    }

    public List<ProductSeedDataDto> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(List<ProductSeedDataDto> productDtos) {
        this.productDtos = productDtos;
    }
}
