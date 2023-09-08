package control;

import java.util.Random;

public class Ex01IfElse {
	public static void main(String[] args) {
		// kiểm tra số chẵn lẻ
		
		Random rd = new Random();
		int number = 5 + rd.nextInt(10);
		System.out.println("Number: " + number);
		if(number % 2 == 0) {
			System.out.println("even number");
		}
		else {
			System.out.println("odd number");
		}
		
		// kiểm tra số có chia hết cho 3 không
		
		if(number % 3 == 0) {
			System.out.println("number again: " + number);
		}
	}
}
