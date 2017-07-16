package com.aralmighty.validation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Target(TYPE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy=PasswordMatchValidator.class)
public @interface PasswordMatch {
	
	String message() default "{register.repeatpassword.mismatch}";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
