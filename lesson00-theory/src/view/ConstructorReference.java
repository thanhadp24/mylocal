package view;

import java.util.function.BiFunction;
import java.util.function.Function;

import bean.Apple;

public class ConstructorReference {
	public static void main(String[] args) {
		
		BiFunction<String, Integer, Apple> b = Apple::new;
		Apple a = b.apply("green", 110);
		
		System.out.println(a);
		
	}
}
