package json.processing.model.dto.binding.xmlBindingModels.seedUsersBindingModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSeedDataWrapper {

    @XmlElement(name = "user")
    List<UserSeedDataDto> userDtos;

    public UsersSeedDataWrapper() {
    }

    public List<UserSeedDataDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserSeedDataDto> userDtos) {
        this.userDtos = userDtos;
    }
}
