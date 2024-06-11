package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.MovieService;

public class App {
		
	private final static String PATH = "aop-third.xml";

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		
		printBeans(context);
		
		// MovieService movieService = context.getBean("movieServiceProxy", MovieService.class);
		MovieService movieService = context.getBean("movieService", MovieService.class);
		
		// auto proxy
		movieService.printName();
		movieService.printCatalog();
		
	}
	
	private static void printBeans(ApplicationContext context) {
		String[] beans = context.getBeanDefinitionNames();
		for(String bean: beans) {
			System.out.println(bean);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
	}
}
