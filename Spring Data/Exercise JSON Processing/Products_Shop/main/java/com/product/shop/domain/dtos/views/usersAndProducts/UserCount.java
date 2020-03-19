package com.product.shop.domain.dtos.views.usersAndProducts;

import com.google.gson.annotations.Expose;

public class UserCount {
    @Expose
    private long usersCount;

    @Expose
    private UserModel[] users;

    public UserCount() {
    }

    public UserCount(long usersCount, UserModel[] users) {
        this.usersCount = usersCount;
        this.users = users;
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }

    public UserModel[] getUsers() {
        return users;
    }

    public void setUsers(UserModel[] users) {
        this.users = users;
    }
}
