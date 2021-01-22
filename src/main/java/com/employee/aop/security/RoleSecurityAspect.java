package com.employee.aop.security;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.annotations.HasAccessRole;
import com.employee.enums.RoleType;

@Aspect
@Component
public class RoleSecurityAspect {

	@Autowired
	SecurityManager securityManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleSecurityAspect.class);

	@Pointcut("execution(* com.employee.web.rest.Controller.*(..))")
	public void myPointcut() {
		// pointcut
	}

	@Around("myPointcut()")
	public Object securityRoleCheck(ProceedingJoinPoint joinPoint) throws Throwable {

		LOGGER.info("enterd securityRoleCheck");

		Annotation annotations[] = null;
		for (Method method : joinPoint.getTarget().getClass().getDeclaredMethods()) {
			if (method.getName().equals(joinPoint.getSignature().getName())) {
				annotations = method.getAnnotations();
			}
		}

		if (annotations[0] != null) {
			if (Boolean.FALSE.equals(verifyRole(annotations[0]))) {
				LOGGER.info("User Does not has permission.");
				throw new SecurityException("User Does not has permission.");
			} else {
				LOGGER.info("User has permission.");
			}
		}
		LOGGER.info("exited securityRoleCheck");
		return joinPoint.proceed();
	}

	private boolean verifyRole(Annotation annotation) {
		HasAccessRole accessRole = (HasAccessRole) annotation;
		List<RoleType> requierdRoleTypes = Arrays.asList(accessRole.allowedRole());
		RoleType roleType = securityManager.getLoggedOnUser().getRole();
		return requierdRoleTypes.contains(roleType);
	}
}
