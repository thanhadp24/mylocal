package com.spring.demo;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		String[] beans = context.getBeanDefinitionNames();
		
		System.out.println(Arrays.toString(beans));
		context.close();
	}
}
