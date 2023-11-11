package com.springboot.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    public String value() default "LUV"; // default course code

    public String message() default "must start with LUV"; // default error message

    public Class<?>[] groups() default {}; // default groups

    public Class<? extends Payload>[] payload() default {}; // default payloads
}
