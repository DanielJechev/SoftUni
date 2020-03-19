package com.product.shop.services.base;

import com.product.shop.domain.dtos.bindings.UserDto;

import java.io.IOException;

public interface UserService {
    void saveUsers(UserDto[] usersDto);

    void getUsersWithProducts() throws IOException;
}
