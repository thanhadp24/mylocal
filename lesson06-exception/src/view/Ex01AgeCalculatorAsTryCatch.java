package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeCalculatorAsTryCatch {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		// cách 2: hậu xử lí(try-catch) --> xử lí khi xảy ra lỗi đảm bảo đoạn mã phía
		// sau vẫn được thực thi
		// đặt đoạn mã mà có khả năng gây lỗi vào try catch
		int bYear = 0;
		do {
			try {
				System.out.println("enter your birth year");
				bYear = Integer.parseInt(ip.nextLine());
				break;
			} catch (NumberFormatException e) {
//				System.out.println("invalid!!!");
//				System.out.println("enter again!");
				e.printStackTrace();
			}
		} while (true);
		int age = Year.now().getValue() - bYear;
		System.out.println("Age: " + age);
		System.out.println("finished!!");

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
