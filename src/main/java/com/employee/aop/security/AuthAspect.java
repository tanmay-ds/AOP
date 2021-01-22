package com.employee.aop.security;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.employee.dto.UserInfoDto;
import com.employee.entity.UserInfo;
import com.employee.repo.UserInfoRepo;

@Aspect
@Component
public class AuthAspect {

	@Autowired
	SecurityManager securityManager;
	
	@Autowired 
	UserInfoRepo userInfoRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthAspect.class);

	@Pointcut("execution(* com.employee.web.rest.Controller.*(..))")
	public void myPointcut() {
		// pointcut
	}

	@Before("myPointcut()")
	public void beforeSecurity(JoinPoint jp) {
		
		UserInfoDto user = securityManager.getLoggedOnUser();
		List<UserInfo> list = userInfoRepo.findAll();

		if (user == null) {

			LOGGER.info("No user authenticated");

			throw new SecurityException("You must login before attempting to access this api: ");

		} else if (!ObjectUtils.isEmpty(user)) {
			if(Boolean.TRUE.equals(securityManager.isLoggedIn()))
					LOGGER.info("Logged in user is {} {}",user.getUserName(),user.getRole());
		}
	}
}
