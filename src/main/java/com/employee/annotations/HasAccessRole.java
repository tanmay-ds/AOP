package com.employee.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.employee.enums.RoleType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HasAccessRole {
	RoleType[] allowedRole();
}
