package com.spring.aop;

import org.aopalliance.intercept.MethodInvocation;

// Step 2: create advice
public class MovieAopAroundAdvice implements org.aopalliance.intercept.MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invoked) throws Throwable {
		
		try {
			// advice before
			LOG("*** ADVICE BEFORE >> " + invoked.getMethod().getName());
			
			Object result = invoked.proceed();
			
			// advice after
			LOG("*** ADVICE AFTER >> " + result);
			
			return result;
		} catch (Exception e) {
			// advice throw exception
			e.printStackTrace();
			throw e;
		}
	}
	
	private static void LOG(String text) {
		System.out.println(text);
	}
}
