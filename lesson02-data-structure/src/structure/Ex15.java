package structure;

import java.util.Scanner;

public class Ex15 {
	public static void main(String[] args) {
		//String sequence = "hello WORLD";
		//System.out.println(sequence.toLowerCase());
		
		//System.out.println(Math.max(5, 9));
		//System.out.println(Math.sqrt(81));
		//System.out.println(Math.random()); // 0 - 100
		
		Scanner rd = new Scanner(System.in);
		//int i = Integer.parseInt(rd.nextLine());
		
		//double d = Double.parseDouble(rd.nextLine());
		
		//String s = rd.nextLine();
		
		//System.out.println("s: " + s);
		//System.out.println("d: " + d);
		//System.out.println("i: " + i);
		
		System.out.println("=============");
		int N = 2;
		for(int i = 1; i <= 10; i++){
            System.out.println(N + " x " + i + " = " + N * i);
        }
	}
}
