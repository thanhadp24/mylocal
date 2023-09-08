package view;

import java.util.Arrays;
import java.util.function.Consumer;

public class Ex04Lambda {
	public static void main(String[] args) {
		// functional interface
		// signature
		// Supplier, Consumer, Predicate, Function, BiFunction, Comparator
		
		// create an instance of functional interface
		Consumer<Integer> consumer = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer number) {
				System.out.println(number);
			}
		};
		// using lambda
		consumer = number -> System.out.println(number);
		
		Arrays.asList(1, 2, 3).forEach(System.out::println);
		
		// lí thuyết: tìm hiểu functional interface, lambda để ứng dụng
		// trong những function có sẵn của JAVA
		
	}
}
