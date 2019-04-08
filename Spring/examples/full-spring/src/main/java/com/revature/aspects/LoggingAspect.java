package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//not working????????????????????????????????
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/* ADVICE
	 * Each type of advice(Before, After, AfterThrowing, 
	 * AfterReturning, Around) is the annotation itself, 
	 * NOT @Advice. 
	 * Following the advice annotation, comes our POINTCUT
	 * The pointcut is the set of points in execution of your 
	 * code at which you want your advice to be applied 
	 * "Where do i want this advice to happen"
	 * meanwhile the type of advice shows us "when" we 
	 * want it to happen
	 * In spring, our pointcuts represent method executions
	 * based on method names and locations
	 * below, we see that we will execute this method
	 * BEFORE the EXECUTION of methods with any(*) return
	 * type, in the com.revature base package. in any sub-package
	 * of that base package, in any class in any of those 
	 * packages, and finally, in any method in any of those
	 * classes, with any parameter list (..)
	 */
	
	//ADVICE(POINTCUT) -- "execution([returnType] [package].[class].[methodName]([paramTypes]))"
	@Before("everyMethod()")
	public void setterInjection(JoinPoint jp) {
		//ADVICE 
		System.out.println("EXECUTING METHOD: " + jp.getSignature()
				+ "\nTarget Object: " + jp.getTarget()
				+ "\nKind: " + jp.getKind());
		
	}
	
	@Pointcut("execution(* com.revature.*.*.*(..))")
	public void everyMethod() {}
	
	@Around("everyMethod()")
	public Object testAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("THINGS BEFORE");
	 Object o = pjp.proceed(); //here, we tell our joinpoint to execute
		System.out.println("THINGS AFTER");
		return o;
	}
	
}
