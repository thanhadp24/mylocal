package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07DecimalToBinary {
	static int  count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] result = decimalToBinary(x);
		
		for(int i = count-1; i >= 0; i--) {
			System.out.println(result[i]);
		}
	}

	private static int[] decimalToBinary(int n) {
		int[] result = new int[100];
		do {
			int tmp = n % 2;
			result[count++] = tmp;
			n = n / 2;
		} while (n != 0);
		return Arrays.copyOfRange(result, 0, count);
	}

}
