package com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.aspect.MovieLogAspect;
import com.spring.service.MovieService;
import com.spring.service.MovieServiceImpl;

@Configuration
public class MovieAspectConfig {

	@Bean
	public MovieService movieService(){
		// JoinPoint
		return new MovieServiceImpl();
	}
	
	@Bean
	public MovieLogAspect movieLogAspect() {
		// advice, pointCut
		return new MovieLogAspect();
	}
}
