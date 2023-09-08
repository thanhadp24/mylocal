package dataStructure;

import java.util.Scanner;

public class Ex05MinMaxOf3Numbers {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a, b, c;
		a = b= c = 0;
		System.out.println("nhập a: ");
		a = check(a);

		System.out.println("nhập b: ");
		b = check(b);

		System.out.println("nhập c: ");
		c = check(c);

		System.out.println("số max: " + max3(a, b, c));
		System.out.println("số min: " + min3(a, b, c));
	}

	private static int check(int number) {
		while (true) {
			String input = sc.nextLine();
			if (input.matches("\\d+")) {
				number = Integer.parseInt(input);
				if (number >= 0 && number < 20) {
					return number;
				} else
					System.out.println("mời bạn nhập lại");
			} else
				System.out.println("mời bạn nhập lại");
		}
	}

	private static int min3(int a, int b, int c) {
		int tmp = (a > b) ? b : a;
		return tmp > c ? c : tmp;
	}

	private static int max3(int a, int b, int c) {
		int tmp = (a < b) ? b : a;
		return tmp < c ? c : tmp;
	}

}
