package com.product.shop.domain.dtos.views.usersAndProducts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersModel {
    @XmlAttribute(name = "count")
    private long usersCount;

    @XmlElement(name = "user")
    private List<UserModel> users;

    public UsersModel() {
    }

    public UsersModel(long usersCount, List<UserModel> users) {
        this.usersCount = usersCount;
        this.users = users;
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
