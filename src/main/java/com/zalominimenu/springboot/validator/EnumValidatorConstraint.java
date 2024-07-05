package com.zalominimenu.springboot.validator;


import com.zalominimenu.springboot.annotation.EnumValidatorCustomerRole;
import com.zalominimenu.springboot.enums.CustomerRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumValidatorConstraint implements ConstraintValidator<EnumValidatorCustomerRole, CustomerRole> {

    CustomerRole[] values;

    @Override
    public void initialize(EnumValidatorCustomerRole constraintAnnotation) {
        values = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(CustomerRole value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(values).contains(value);
    }
}