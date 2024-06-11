package com.springmvc.model;

public class MockupData {
	private MockupData() {
	}
	
	public static String[] countries() {
		return new String[] {"Brazil", "France", "Italy"};
	}
	
	public static String[] languages() {
		return new String[] {"Swing desktop", "Spring MVC webapp", "Spring boot"};
	}
	
	public static String[] operatingSystems() {
		return new String[] {"MacOs", "Window", "Linux"};
	}
}
