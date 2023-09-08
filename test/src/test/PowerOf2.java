package test;

import java.util.Scanner;

public class PowerOf2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
}

	private static boolean isPower(int n) {
		double t = Math.log(n) / Math.log(2);
		if (Math.ceil(t) == Math.floor(t))
			return true;
		return false;
	}

}
