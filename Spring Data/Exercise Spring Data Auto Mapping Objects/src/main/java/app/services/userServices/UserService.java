package app.services.userServices;

import app.domain.dtos.LoginUserDto;
import app.domain.dtos.RegisterUserDto;
import app.domain.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String registerUser(RegisterUserDto registerUserDto);
    User findUserByEmail(String email);
    String loginUser(LoginUserDto loginUserDto);
    String logoutUser();
}
