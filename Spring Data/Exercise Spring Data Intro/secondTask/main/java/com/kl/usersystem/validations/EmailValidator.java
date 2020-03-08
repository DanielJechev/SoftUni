package com.kl.usersystem.validations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+[\\w.-]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()) {
            return false;
        }
        return true;
    }
}
