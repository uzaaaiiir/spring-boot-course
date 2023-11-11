package com.springboot.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (code != null) {
            return code.startsWith(coursePrefix);
        }

        return true;
    }
}
