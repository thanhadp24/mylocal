package view;

import java.util.function.Function;

public class ComposingFuntions {
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> f = x -> x + 1;	 // f(x)
		Function<Integer, Integer> g = x -> x * 2;   // g(x)
		Function<Integer, Integer> h = f.andThen(g); // g(f(x))
		// Function<Integer, Integer> h = f.compose(g); // f(g(x))
		int result = h.apply(1);
		System.out.println("result: " + result);
	}
}
