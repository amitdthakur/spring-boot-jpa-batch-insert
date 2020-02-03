package com.jpa.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.mkyong.*.*(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		logger.info("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
	}
}
