package com.springboot.eschool.validations;

import com.springboot.eschool.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    List<String> weakPassword;
    @Override
    public void initialize(PasswordValidator passwordValidator) {
        weakPassword = Arrays.asList("12345", "password", "PASSSWORD", "qwerty");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext cxt){
        return passwordField != null && (!weakPassword.contains(passwordField));
    }

}
