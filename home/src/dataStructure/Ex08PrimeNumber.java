package dataStructure;

import java.util.Scanner;

import javax.security.sasl.SaslException;

public class Ex08PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double number = 0;
		int count = 0;
		while (true) {
			System.out.println("nhập số: ");
			String input = sc.nextLine();
			if (input.matches("\\d+")) {
				number = Double.parseDouble(input);
				System.out.println(isPrime(number));
				return;
			} else {
				System.out.println("mời bạn nhập lại:");
				count++;
			}
			if (count == 5) {
				System.out.println("kết thúc");
				return;
			}
		}

	}

	private static boolean isPrime(double n) {
		if(n <= 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
