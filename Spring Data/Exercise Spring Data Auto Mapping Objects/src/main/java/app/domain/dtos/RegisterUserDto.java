package app.domain.dtos;

import app.annotations.Password;
import app.domain.entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import javax.validation.constraints.Email;

public class RegisterUserDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;

    public RegisterUserDto(String email, String password, String confirmPassword, String name) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
    }

    @Email(regexp = "^([A-Za-z\\d]+[\\.\\-\\_]*[A-Za-z\\d]+)@([\\w\\d\\.\\_\\-]+(\\.)+[\\w\\d]+)$",
            message = "Invalid email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Password(containsDigit = true,
            containsLowerCase = true,
            containsUpperCase = true,
            maxLength = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
