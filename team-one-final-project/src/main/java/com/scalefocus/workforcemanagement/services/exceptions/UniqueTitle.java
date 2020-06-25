package com.scalefocus.workforcemanagement.services.exceptions;

import com.scalefocus.workforcemanagement.services.exceptions.validators.UniqueTeamTitleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueTeamTitleValidator.class)
public @interface UniqueTitle {
    String message() default "{com.scalefocus.workforcemanagement.services.exceptions.UniqueTitle.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
