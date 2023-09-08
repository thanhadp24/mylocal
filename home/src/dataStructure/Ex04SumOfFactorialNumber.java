package dataStructure;

import java.util.Random;

public class Ex04SumOfFactorialNumber {
	public static void main(String[] args) {
		Random rd = new Random();
		long sum = 0;
		for(int i = 1; i <= 4; i++) {
			int number = rd.nextInt(10, 21);
			 long tmp = factorial(number);
			 System.out.println(number + "! = " + tmp);
			 sum += tmp;
		}
		System.out.println("sum = "+ sum);
		
	}

	private static long factorial(int n) {
		long sum = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}

}
