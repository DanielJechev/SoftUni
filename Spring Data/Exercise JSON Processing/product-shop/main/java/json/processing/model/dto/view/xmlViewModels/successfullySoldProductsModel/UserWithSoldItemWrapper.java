package json.processing.model.dto.view.xmlViewModels.successfullySoldProductsModel;

import json.processing.model.dto.view.jsonViewModels.UserWithSoldItemViewModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldItemWrapper {

    @XmlElement(name = "user")
    List<UserWithSoldItemViewModel> viewModelWrapper;

    public UserWithSoldItemWrapper() {
    }

    public List<UserWithSoldItemViewModel> getViewModelWrapper() {
        return viewModelWrapper;
    }

    public void setViewModelWrapper(List<UserWithSoldItemViewModel> viewModelWrapper) {
        this.viewModelWrapper = viewModelWrapper;
    }
}
