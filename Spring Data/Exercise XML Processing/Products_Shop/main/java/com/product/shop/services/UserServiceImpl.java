package com.product.shop.services;

import com.product.shop.domain.dtos.bindings.UsersDto;
import com.product.shop.domain.entities.User;
import com.product.shop.domain.dtos.views.usersAndProducts.ProductCount;
import com.product.shop.domain.dtos.views.usersAndProducts.UsersModel;
import com.product.shop.domain.dtos.views.usersAndProducts.UserModel;
import com.product.shop.repositories.UserRepository;
import com.product.shop.services.base.UserService;
import com.product.shop.utils.base.JaxbUtil;
import com.product.shop.utils.base.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, JaxbUtil jaxbUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.jaxbUtil = jaxbUtil;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public void saveUsers(UsersDto usersDto) {
        User[] users = this.modelMapper.map(usersDto.getUserDtos(), User[].class);
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
    public void getUsersWithProducts() throws IOException, JAXBException {
        List<User> users = this.userRepository.getAllUsersProducts();
        UserModel[] usersModel = this.modelMapper.map(users, UserModel[].class);
        UsersModel userCount = new UsersModel(usersModel.length, Arrays.asList(usersModel));
        userCount.getUsers()
                .forEach(u -> u.setSold(new ProductCount(u.getSoldProducts().size(), u.getSoldProducts())));

        this.jaxbUtil.saveToXML("users-and-products", userCount);
    }
}
