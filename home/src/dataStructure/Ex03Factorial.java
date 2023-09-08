package dataStructure;

import java.util.Scanner;

public class Ex03Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(x + "! = " + factorial(x));
	}
	
	private static long factorial(int n) {
		long sum = 1;
		for(int i = 1; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}
}
