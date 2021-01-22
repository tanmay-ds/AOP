package com.employee.aop.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("within(com.employee..*)")
	public void appPacakgePointcut() {
		// Pointcut
	}

	@Around("appPacakgePointcut()")
	public Object logAround(ProceedingJoinPoint jp) throws Throwable {
		log.info("Entered: {}.{} with arguments:- {}", jp.getTarget().getClass().getName(), jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		try {
			Object result = jp.proceed();
			log.info("Exited: {}.{} with result:- {}", jp.getTarget().getClass().getName(), jp.getSignature().getName(),
					result);
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

}
