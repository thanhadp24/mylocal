package control;

import java.util.Random;

public class Ex05Operator {
	public static void main(String[] args) {
		// Syntax: expression ? statement 1: statement 2
		// is odd number
		
		int number = new Random().nextInt(10);
		String text = (number % 2 == 0) ? "isEven": "isOdd";
		System.out.println("text: " + text);
		
	}
}
