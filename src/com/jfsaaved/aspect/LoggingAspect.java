package com.jfsaaved.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class LoggingAspect {
	
	
	// @Before("execution(public String com.jfsaaved.model.Circle.getName())")
	@Before("allGetters()")
	public void loggingAdvice() {
		System.out.println("Advice run. Get method called.");
	}
	
	/*
	 * Wildcards
	 * If you want the same advice to applied to different points / different pointcuts
	 * An advice that applies to multiply methods
	 * Can add packages in the beginning
	 * "execution(public * get*())"
	 * "execution(public * get*())" 0 arguments
	 * "execution(public * get*(..))" 0 or more arguments
	 * "execution(public * get*(*))" 1 or more arguments
	 */
	
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second advice ran. Get method called.");
	}
	
	
	/*
	 * Pointcuts
	 * For multiple expressions
	 * You don't have to use the pattern for each and every advice
	 * If you want one particular expression to apply for different advice
	 */
	
	@Pointcut("execution(public * get*())")
	public void allGetters() {}


}
