package com.redshift.LibrarApplicationn.Model;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.servlet.annotation.HttpConstraint;
//import javax.validation.Constraint;
//import javax.validation.Payload;

import com.fasterxml.jackson.core.util.RequestPayload;

@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
@HttpConstraint//(value = AgeValidation.class)
public @interface Age {
	 String message() default "You are not major";
	   Class<?>[]  groups() default{};
       Class<? extends RequestPayload>[] payload() default {};
}
