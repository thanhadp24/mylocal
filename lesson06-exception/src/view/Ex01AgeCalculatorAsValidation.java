package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeCalculatorAsValidation {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		// cách 1: tiền xử lí(validate) --> đảm bảo dữ liệu không bị lỗi
		int bYear;
		// validate
		do {
			System.out.println("enter birth year");
			String bYearAsString = ip.nextLine();
			if (bYearAsString.matches("\\d+")) {
				bYear = Integer.parseInt(bYearAsString);
				break;
			} else {
				System.out.println("==> Invalid year\n ");
			}
		} while (true);

		int age = Year.now().getValue() - bYear;
		System.out.println("age: " + age);
	}

	/*
	 * 
	 * Exception in thread "main" java.lang.NumberFormatException: For input string:
	 * "hello" at java.base/java.lang.NumberFormatException.forInputString(
	 * NumberFormatException.java:67) at
	 * java.base/java.lang.Integer.parseInt(Integer.java:668) at
	 * java.base/java.lang.Integer.parseInt(Integer.java:786) at
	 * view.Ex01AgeCalculator.main(Ex01AgeCalculator.java:12)
	 * 
	 * 
	 */
}
