package com.spring.demo;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// classPathResource >> target/classes
		String path = "configure/spring-beans.xml";
		
		// add prefix -> classpath:
		// path = "classpath:configure/spring-beans.xml";
		
		path = "spring-beans.xml";
		
		// ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		//ConfigurableApplicationContext context = new FileSystemXmlApplicationContext(path);
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(path, App.class);
		
		String[] beans = context.getBeanDefinitionNames();
		
		System.out.println(Arrays.toString(beans));
		context.close();
	}
}
