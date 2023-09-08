package dataStructure;

import java.util.Scanner;

public class Ex06Palindrome {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//int number = 0;
		while (true) {
			System.out.println("nhập số: ");
			String check = sc.nextLine();
			if (check.matches("[0-9]{2,}")) {
				// number = Integer.parseInt(check);
				System.out.println(palindrome(check));
				return;
			} else {
				System.out.println("nhập lại: ");
			}
		}
	}

	private static boolean palindrome(String input) {
		int left;
		int right = input.length() - 1;
		for (left = 0; left < right; left++, right--) {
			if (input.charAt(left) != input.charAt(right))
				return false;
		}
		return true;
	}
}
