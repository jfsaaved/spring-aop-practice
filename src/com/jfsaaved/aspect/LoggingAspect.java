package com.jfsaaved.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("exection(public String getName())")
	public void LoggingAdvice() {
		System.out.println("Advice run. Get method called.");
	}

}
