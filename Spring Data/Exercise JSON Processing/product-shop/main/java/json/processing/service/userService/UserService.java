package json.processing.service.userService;

import json.processing.model.dto.binding.jsonBindingModels.UsersBindingModel;
import json.processing.model.dto.binding.xmlBindingModels.seedUsersBindingModels.UsersSeedDataWrapper;
import json.processing.model.dto.view.jsonViewModels.UserViewModel;
import json.processing.model.dto.view.jsonViewModels.usersAndProductsQuery4.UsersViewModelWrapper;
import json.processing.model.entity.User;


public interface UserService {

    void persist(UsersBindingModel userDto);

    UserViewModel getUserById(Long sellerID);

    UsersViewModelWrapper getAllUsersWithSoldProduct();

    void persistAllUsers(UsersSeedDataWrapper userWrapper);

    User userById(long buyer);
}
