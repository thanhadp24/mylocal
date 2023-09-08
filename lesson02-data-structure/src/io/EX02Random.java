package io;

import java.util.Random;

/**
 * 1. Random a number less than N ( 0 -  N )
 * 2. Random a number from A to B
 * 3. Random an element in a list 
 *
 */
public class EX02Random {
	public static void main(String[] args) {
		Random rd = new Random();
		int number = rd.nextInt(10);
		System.out.println("Random number: " + number);
		
		int digit = 26 + rd.nextInt(34 - 26 + 1);
		System.out.println("Random digit: " + digit);
	
		String[] letters = {"A", "B", "C", "D", "E"};
		int length = letters.length; 
				
		System.out.println("Value: " + letters[rd.nextInt(length)]);
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + ":" + letters[rd.nextInt(length)]);
		}
	}
}
