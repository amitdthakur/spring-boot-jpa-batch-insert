package com.jpa.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

  /**
   * Logger instance
   */
  private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

  @Before("execution(* com.jpa.sample.*.*(..))")
  public void logBeforeFunctionCall(JoinPoint joinPoint) {
    logger.info("Before function executed : " + joinPoint.getSignature().getName());
  }

  @After("execution(* com.jpa.sample.*.*(..))")
  public void logAfterFunctionCall(JoinPoint joinPoint) {
    logger.info("After function executed : " + joinPoint.getSignature().getName());
  }
}
