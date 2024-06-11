package com.spring.bean;

public class MovieCatalog {

	private final String catalog;

	public MovieCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	public String getCatalog() {
		return catalog;
	}

	public void showMovie() {
		switch (catalog) {
		case "action":
			System.out.println("Hot Movie >> Forever >> Action...");
			break;
		case "adventure":
			System.out.println("Hot Movie >> Avatar >> Adventure...");
			break;
		}
	}
}
