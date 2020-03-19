package com.product.shop.domain.dtos.views.successfullySoldProducts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersModel {
    @XmlElement(name = "user")
    private List<UserModel> users;

    public UsersModel() {
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
