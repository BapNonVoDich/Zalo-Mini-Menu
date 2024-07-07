package com.zalominimenu.springboot.annotation;

import com.zalominimenu.springboot.enums.CustomerRole;
import com.zalominimenu.springboot.validator.EnumValidatorConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidatorConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull
public @interface EnumValidatorCustomerRole {
    CustomerRole[] anyOf();
    String message() default "vai trò phải là một trong các giá trị sau: {anyOf}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}