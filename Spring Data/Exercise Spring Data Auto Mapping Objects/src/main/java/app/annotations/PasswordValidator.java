package app.annotations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final String SHORT_PASSWORD_ERROR_MESSAGE = "The password must be at least 6 characters.";
    private static final String LONG_PASSWORD_ERROR_MESSAGE = "The password must be shorter than 30 characters.";
    private static final String CONTAIN_LOWERCASE_ERROR_MESSAGE = "The password must contain a lowercase.";
    private static final String CONTAIN_UPPERCASE_ERROR_MESSAGE = "The password must contain an uppercase.";
    private static final String CONTAIN_DIGIT_ERROR_MESSAGE = "The password must contain a digit.";
    private static final String NULL_PASSWORD_ERROR_MESSAGE = "The password can not be null.";

    private int minLength;
    private int maxLength;
    private boolean containsDigit;
    private boolean containsLowerCase;
    private boolean containsUpperCase;
    @Override
    public void initialize(Password password) {
        this.minLength=password.minLength();
        this.maxLength=password.maxLength();
        this.containsDigit=password.containsDigit();
        this.containsLowerCase=password.containsLowerCase();
        this.containsUpperCase=password.containsUpperCase();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){
            setErrorMessage(context, NULL_PASSWORD_ERROR_MESSAGE);
            return false;
        }
        if(value.length()<minLength){
            setErrorMessage(context, SHORT_PASSWORD_ERROR_MESSAGE);
            return false;
        }
        if(value.length()>maxLength){
            setErrorMessage(context, LONG_PASSWORD_ERROR_MESSAGE);
            return false;
        }

        if(!isContainingDigit(value) && this.containsDigit){
            setErrorMessage(context, CONTAIN_DIGIT_ERROR_MESSAGE);
            return false;
        }

        if(!isContainingLowerCase(value) && this.containsLowerCase){
            setErrorMessage(context, CONTAIN_LOWERCASE_ERROR_MESSAGE);
            return false;
        }
        if(!isContainingUpperCase(value) && this.containsUpperCase){
            setErrorMessage(context, CONTAIN_UPPERCASE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private static void setErrorMessage(ConstraintValidatorContext context, String errorMessage) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addConstraintViolation();
    }
    private boolean isContainingLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(Character.isLowerCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean isContainingUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean isContainingDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
