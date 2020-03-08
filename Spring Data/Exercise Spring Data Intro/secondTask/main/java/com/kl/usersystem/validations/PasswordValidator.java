package com.kl.usersystem.validations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private int minLength;
    private int maxLength;
    private boolean containsDigit;
    private boolean containsLowercaseLetter;
    private boolean containsUppercaseLetter;
    private boolean containsSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.containsDigit = password.containsDigit();
        this.containsLowercaseLetter = password.containsLowercaseLetter();
        this.containsUppercaseLetter = password.containsUppercaseLetter();
        this.containsSpecialSymbol = password.containsSpecialSymbol();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if (password.length() < this.minLength || password.length() > this.maxLength) {
//            throw new IllegalArgumentException("Password should be at least 4 and maximum 30 characters long.");
            return  false;
        }

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find() && this.containsLowercaseLetter) {
//            throw new IllegalArgumentException("Password should contain lowercase letter.");
            return  false;
        }

        Pattern pattern2 = Pattern.compile("[A-Z]");
        Matcher matcher2 = pattern2.matcher(password);

        if (!matcher2.find() && this.containsUppercaseLetter) {
//            throw new IllegalArgumentException("Password should contain uppercase letter.");
            return  false;
        }

        Pattern pattern3 = Pattern.compile("[0-9]");
        Matcher matcher3 = pattern3.matcher(password);
        if (!matcher3.find() && this.containsDigit) {
//            throw new IllegalArgumentException("Password should contain a number.");
            return  false;
        }

        Pattern pattern4 = Pattern.compile("[!@$%^&*()_+<>?]");
        Matcher matcher4 = pattern4.matcher(password);
        if (!matcher4.find() && this.containsSpecialSymbol) {
//            throw new IllegalArgumentException("Password should contain one of (!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?) symbols");
            return  false;
        }
        return true;
    }
}
