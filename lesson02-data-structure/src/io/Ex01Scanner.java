package io;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = ip.nextLine();
		
		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.print("Enter age: ");
		// int age = ip.nextInt();
		// ip.nextLine();
		int age = Integer.parseInt(ip.nextLine()); // nếu sau đó mình nhập vào chuỗi thì dùng này sẽ mất đi enter
		
		System.out.print("Enter address: ");
		String address = ip.nextLine();
		
		
		System.out.println("============");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Hobbies: " + hobbies);
		System.out.println("Address: " + address);
		
		
	}
}
