package com.github.veeshostak.spring.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD}) // apply on methods and fields
@Retention(RetentionPolicy.RUNTIME)// how long anot will be used
public @interface CourseCode {
	
	// default course code
	public String value() default "CS";
	
	// default error message
	public String message() default "must start with CS";
	
	// default groups (can group related constraints)
	public Class<?>[] groups() default {};
	
	// default payload (additional info about validation error)
	public Class<? extends Payload>[] payload() default {};
}
