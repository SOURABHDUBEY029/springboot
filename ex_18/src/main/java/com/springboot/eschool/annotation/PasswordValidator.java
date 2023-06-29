package com.springboot.eschool.annotation;

import com.springboot.eschool.validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default "Password strength is weak, choose a strong password";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
