package dataStructure;

import java.util.Scanner;

public class Ex01MultipleOf2Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		int count = 0;
		while(true) {
			System.out.println("nhập số: ");
			String input = sc.nextLine();
			if(input.matches("\\d+")) {
				number = Integer.parseInt(input);
				System.out.println(isMultipleOf2(number)); 
				return;
			} else {
				System.out.println("nhập vào số nguyên dương: ");
				count++;
			}
			if(count == 5) {
				System.out.println("kết thúc");
				return;
			}
		}
	}
	
	private static boolean isMultipleOf2(int n) {
		return n % 2 == 0;
	}

}
