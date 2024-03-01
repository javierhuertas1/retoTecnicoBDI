package com.mycompany.user.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

public class EmailValidator implements ConstraintValidator<EmailRegex, String> {

    @Value("${mycompany.email.validation.regex}")
    private String emailRegex;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches(emailRegex);
    }
}
