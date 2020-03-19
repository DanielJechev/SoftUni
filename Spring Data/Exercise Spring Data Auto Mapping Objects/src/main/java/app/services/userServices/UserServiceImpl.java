package app.services.userServices;

import app.domain.dtos.LoginUserDto;
import app.domain.dtos.RegisterUserDto;
import app.domain.entities.User;
import app.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static final String REGISTER_USER=" was registered";
    private static final String LOGIN_USER="Successfully logged in ";
    private static final String LOGOUT_USER = " successfully logged out";
    private UserRepository userRepository;
    private ModelMapper mapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
    public String registerUser(RegisterUserDto registerUserDto) {
        User user = mapper.map(registerUserDto, User.class);
        this.userRepository.saveAndFlush(user);
        if (this.userRepository.findAll().size() == 1) {
            this.userRepository.setUserAsAdmin(user.getId());
        }
        return user.getName() + REGISTER_USER;
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.getByEmail(email);
    }

    @Override
    public String loginUser(LoginUserDto loginUserDto) {
        StringBuilder output = new StringBuilder();
        String loginEmail = loginUserDto.getEmail();
        String loginPassword = loginUserDto.getPassword();
        User foundUser = this.userRepository.getByEmail(loginEmail);
        if(foundUser.getEmail()==null){
            output.append("User doesn't exists.");
        }else if(!foundUser.getPassword().equals(loginPassword)){
            output.append("Incorrect Password/Username");
        }else{
            output.append(LOGIN_USER).append(foundUser.getName());
        }
        return output.toString();
    }

    @Override
    public String logoutUser() {
        List<User> users = this.userRepository.findAll();
        StringBuilder output = new StringBuilder();
        if(users.size()==0){
            output.append("Cannot log out. No user was logged in.");
        }else{
            output.append("User ")
                    .append(users.get(0).getName())
                    .append(LOGOUT_USER);
        }
        return output.toString();
    }
}
