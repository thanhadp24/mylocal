package dataStructure;

import java.util.Arrays;
import java.util.Random;

public class Ex10RandomOf5Numbers {
	public static void main(String[] args) {
		Random rd = new Random();
		int count = 0;
		int[] result = new int[5];
		while (true) {
			int x = rd.nextInt(20, 31);
			if (isExist(result, x)) {
				continue;
			}
			//System.out.println(x);
			result[count++] = x;
			if (count == 5)
				break;
		}
		for(int i:result) {
			System.out.println(i);
		}

	}

	private static boolean isExist(int[] numbers, int n) {
		for (int number : numbers) {
			if (number == n)
				return true;
		}
		return false;
	}

}
