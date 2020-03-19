package com.product.shop.services.base;

import com.product.shop.domain.dtos.bindings.UserDto;
import com.product.shop.domain.dtos.bindings.UsersDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface UserService {
    void saveUsers(UsersDto usersDto);

    void getUsersWithProducts() throws IOException, JAXBException;
}
