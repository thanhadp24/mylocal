package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.MovieRecommender;
import com.spring.config.AppConfig;

public class App {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		print(context);
		
		MovieRecommender movieRecommender = context.getBean("movieRecommender", MovieRecommender.class);
		movieRecommender.recommend();
		
		context.close();
	}
	
	private static void print(ApplicationContext context) {
		String[]  beans = context.getBeanDefinitionNames();
		for(String bean: beans) {
			System.out.println(bean);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
	}
}
