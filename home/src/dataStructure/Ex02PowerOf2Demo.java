package dataStructure;

import java.util.Scanner;

public class Ex02PowerOf2Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		int count = 0;
		while (true) {
			System.out.println("nhập vào 1 số: ");
			String input = sc.nextLine();
			if (input.matches("\\d+")) {
				number = Integer.parseInt(input);
				System.out.println(isPowerOf2(number));
				return;
			} else {
				System.out.println("nhập lại số nguyên dương: ");
				count++;
			}
			if (count == 5) {
				System.out.println("kết thúc");
				return;
			}
		}
	}

	private static boolean isPowerOf2(int n) {
		double check = Math.log(n) / Math.log(2);
		return Math.ceil(check) == Math.floor(check);
	}
}
