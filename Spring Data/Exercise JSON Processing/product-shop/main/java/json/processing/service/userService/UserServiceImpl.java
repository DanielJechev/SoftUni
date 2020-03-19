package json.processing.service.userService;

import json.processing.model.dto.binding.jsonBindingModels.UsersBindingModel;
import json.processing.model.dto.binding.xmlBindingModels.seedUsersBindingModels.UsersSeedDataWrapper;
import json.processing.model.dto.view.jsonViewModels.UserViewModel;
import json.processing.model.dto.view.jsonViewModels.usersAndProductsQuery4.ProductModels;
import json.processing.model.dto.view.jsonViewModels.usersAndProductsQuery4.SoldProducts;
import json.processing.model.dto.view.jsonViewModels.usersAndProductsQuery4.UserViewModelQuery4;
import json.processing.model.dto.view.jsonViewModels.usersAndProductsQuery4.UsersViewModelWrapper;
import json.processing.model.entity.User;
import json.processing.repository.UserRepository;
import json.processing.util.modelMapper.DtoConvertUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void persist(UsersBindingModel userDto) {
        User user = DtoConvertUtil.convert(userDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserViewModel getUserById(Long sellerID) {
        User user = this.userRepository.getOne(sellerID);
        return DtoConvertUtil.convert(user, UserViewModel.class);
    }

    @Override
    public UsersViewModelWrapper getAllUsersWithSoldProduct() {
        List<User> users = this.userRepository.usersWithSoldProduct();
        UsersViewModelWrapper uvw = new UsersViewModelWrapper();

        uvw.setUsersCount((long)users.size());
        List<UserViewModelQuery4> userViewModel = new ArrayList<>();
        users.forEach(u -> setUserViewModels(u, userViewModel));
        uvw.setUsers(userViewModel);

        return uvw;
    }

    @Override
    public void persistAllUsers(UsersSeedDataWrapper userWrapper) {
        List<User> users =
                userWrapper.getUserDtos()
                        .stream()
                        .map(u -> DtoConvertUtil.convert(u, User.class))
                .collect(Collectors.toList());
        this.userRepository.saveAll(users);
    }

    @Override
    public User userById(long id) {
        return this.userRepository.getOne(id);
    }

    private void setUserViewModels(User u, List<UserViewModelQuery4> userViewModel) {
        UserViewModelQuery4 uvmq = new UserViewModelQuery4();
        uvmq.setAge(u.getAge());
        uvmq.setFirstName(u.getFirstName());
        uvmq.setLastName(u.getLastName());

        SoldProducts sp = new SoldProducts();
        sp.setCount((long)u.getSellingProducts().size());
        List<ProductModels> productModels =
                u.getSellingProducts().stream()
                .map(p -> {
                    ProductModels pm = new ProductModels();
                    pm.setName(p.getName());
                    pm.setPrice(p.getPrice());
                    return pm;
                }).collect(Collectors.toList());
        sp.setProducts(productModels);
        uvmq.setSoldProducts(sp);

        userViewModel.add(uvmq);
    }
}
