package com.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommender {
	
	@Autowired
	@Qualifier("action")
	private MovieCatalog movieCatalog;
	
	public void recommend() {
		System.out.println(movieCatalog.getCatalog());
		movieCatalog.showMovie();
	}
}
