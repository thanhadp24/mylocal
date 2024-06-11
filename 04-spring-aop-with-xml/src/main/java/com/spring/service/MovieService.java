package com.spring.service;

// Step1: JoinPoint class
public class MovieService {
	
	private String name;
	private String catalog;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	// JoinPoint methods
	public void printName() {
		System.out.println("MovieService >> " + name);
	}
	
	public void printCatalog() {
		System.out.println("MovieService >> " + catalog);
	}
	
}
