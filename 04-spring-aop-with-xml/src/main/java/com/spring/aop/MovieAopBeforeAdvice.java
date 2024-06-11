package com.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// Step 2: create advice
public class MovieAopBeforeAdvice implements MethodBeforeAdvice{
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("*** MovieAopBeforeAdvice >> BEFORE >> " + method.getName());
	}
	
}
