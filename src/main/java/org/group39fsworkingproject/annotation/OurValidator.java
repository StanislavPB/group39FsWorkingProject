package org.group39fsworkingproject.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class OurValidator implements ConstraintValidator<OurValidation,String> {

    @Override
    public void initialize(OurValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            addConstraintViolation(context,"Password cannot be null");
            return false; // неправильный пароль, если он null
        }

        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Password length must be at least 8 characters long");
        }

        if (!password.matches(".*[A-Z].*")){
            errors.add("Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*\\d.*")){
            errors.add("Password must contain at least one digit");
        }

        if (!password.matches(".*[!@#$%^&*()].*")){
            errors.add("Password must contain at least one special character");
        }

        if (!password.matches("[A-Za-z0-9!@#$%^&*()]+")){
            errors.add("Password must contain invalid character");
        }

        if (!errors.isEmpty()) {
            for (String error : errors){
                addConstraintViolation(context,error);
            }
            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}
