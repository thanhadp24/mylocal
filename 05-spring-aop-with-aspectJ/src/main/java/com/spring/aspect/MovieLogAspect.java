package com.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MovieLogAspect {
	// class annotated with @Aspect contains: advice, pointCut
	
	// execution(* com.spring.service.*.*(..))
	
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.spring.service.MovieService.*(..))")
	public void movieServicePointCut() {};
	
	@Before("movieServicePointCut()")
	public void forMovieService(JoinPoint joinpoint) {
		LOGGER.info(">>> Add LOG before MovieService " + joinpoint.getSignature().getName());
	}
	
	@Before("movieServicePointCut()")
	public void forAnalyseService(JoinPoint joinpoint) {
		LOGGER.info(">>> Add LOG for analysing " + joinpoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut = "movieServicePointCut()", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info(">>> AFTER RETURNING >> " + joinPoint.getSignature().getName());
		LOGGER.info("result >> " + result);
	}
}
