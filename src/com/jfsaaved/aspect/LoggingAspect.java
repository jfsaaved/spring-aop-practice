package com.jfsaaved.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jfsaaved.model.Circle;


@Aspect
public class LoggingAspect {
	
	
	// @Before("execution(public String com.jfsaaved.model.Circle.getName())")
	@Before("allGetters()")
	public void loggingAdvice() {
		//System.out.println("Advice run. Get method called.");
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
		//System.out.println("Second advice ran. Get method called.");
	}
	
	
	/*
	 * Pointcuts
	 * For multiple expressions
	 * You don't have to use the pattern for each and every advice
	 * If you want one particular expression to apply for different advice
	 */
	
	@Pointcut("execution(public * get*())")
	public void allGetters() {}
	
	// @Pointcut("execution(* * com.jfsaaved.model.Circle.*(..)")
	/*
	 * Within Pointcuts
	 * within(com.jfsaaved.model.Circle)
	 * within(com.jfsaaved.model..*) - Affect subpackages as well
	 */
	@Pointcut("within(com.jfsaaved.model.Circle)")
	public void allCircleMethods() {}
	
	
	@Before("allCircleMethods()")
	public void allCircleMethodsAdvice() {
		System.out.println("All within methods called.");
	}
	
	/*
	 * args() Point cut methods
	 * Take class names as parameters
	 * @Pointcut(args())
	 * public void argsMethods() {}
	 * 
	 * 
	 * It is best practice to mix and match point cut expressions / combine them rather
	 * ex: I want a point cut for all getters of Circle class
	 * allGetters() && allCircleMethods() inside @Before for example
	 */
	
	/*
	 * JoinPoints
	 * System.out.println(joinPoint.toString());
	 * joinPoint.getTarget() - Gives us the object, who's method were called
	 * Circle circle = (Circle) joinPoint.getTarget();
	 */
	
	@Before("allCircleMethods()")
	public void joinPointaAdvice(JoinPoint joinPoint) {

	}
	
	@Before("args(String)")
	public void stringArgumentMethods(){
		System.out.println("A method that takes String arguments has been called - NaN");
	}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("A method that takes String arguments has been called: "+name);
	}
	
	@After("args(name)")
	public void stringArgumentMethodsAfter(String name){
		System.out.println("After - A method that takes String arguments has been called: "+name);
	}
	
	/*
	 * 	@AfterReturning("args(name)")
	 *	public void exceptionAdvice(String name) {
	 *		System.out.println("After Throw - A method that takes String arguments has been called: "+name);
	 *	}
	 */
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumentMethodsAfterReturning(String name, String returnString){
		System.out.println("After Returning - A method that takes String arguments has been called: "+name + ". The output value is: "+ returnString);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name) {
		System.out.println("After Throw - A method that takes String arguments has been called: "+name);
	}
	
	@Around("allGetters()")
	public Object aroundAdivce(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnValue = null;
		
		try {
			System.out.println("Around Advice start");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("Around Advice returning");
		} catch (Throwable e) {
			System.out.println("Around Advice throw");
		}
		
		System.out.println("Around Advice end");
		
		return returnValue;
	}
	


}
