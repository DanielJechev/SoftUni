package com.product.shop.utils;

import com.product.shop.utils.base.ValidatorUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidatorUtilImpl implements ValidatorUtil {
    private final Validator validator;

    public ValidatorUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <T> List<String> getViolationsMessage(T item) {
        List<String> violationsMessage = new ArrayList<>();

        Set<ConstraintViolation<T>> violations = this.validator.validate(item);

        for (ConstraintViolation<T> violation : violations) {
            violationsMessage.add(violation.getMessage());
        }

        return violationsMessage;
    }
}
