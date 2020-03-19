package com.product.shop.services;

import com.product.shop.domain.dtos.bindings.UserDto;
import com.product.shop.domain.entities.User;
import com.product.shop.domain.dtos.views.usersAndProducts.ProductCount;
import com.product.shop.domain.dtos.views.usersAndProducts.UserCount;
import com.product.shop.domain.dtos.views.usersAndProducts.UserModel;
import com.product.shop.repositories.UserRepository;
import com.product.shop.services.base.UserService;
import com.product.shop.utils.base.GsonUtil;
import com.product.shop.utils.base.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final GsonUtil gsonUtil;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, GsonUtil gsonUtil, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gsonUtil = gsonUtil;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public void saveUsers(UserDto[] usersDto) {
        User[] users = this.modelMapper.map(usersDto, User[].class);
        Arrays.stream(users).forEach(u -> {
            List<String> violationsMessage = this.validatorUtil.getViolationsMessage(u);

            if (violationsMessage.size() > 0) {
                violationsMessage.forEach(System.out::println);
            } else {
                this.userRepository.save(u);
            }
        });
    }

    @Override
    public void getUsersWithProducts() throws IOException {
        List<User> users = this.userRepository.getAllUsersProducts();
        UserModel[] usersModel = this.modelMapper.map(users, UserModel[].class);
        UserCount userCount = new UserCount(usersModel.length, usersModel);
        Arrays.stream(userCount.getUsers())
                .forEach(u -> u.setSold(new ProductCount(u.getSoldProducts().size(), u.getSoldProducts())));

        this.gsonUtil.saveJSONtoFile("users-and-products", userCount);
    }
}
