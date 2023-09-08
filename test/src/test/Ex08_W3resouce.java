package test;

import java.util.Scanner;

public class Ex08_W3resouce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		if(s1.equals(s2)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
	}
}
