package view;

import java.util.Arrays;

/*
 * cho mảng int[] a = {1,2,5,2,9,1};
 * tìm ra các phần tử chỉ xuất hiện 1 lần và display them with ascending
 * ex: ==> 5, 9 
 */
public class Ex04GetUniqueNumber {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 4, 2, 9, 0, 1 };
		int[] result = getUniqueNumber(numbers);
		Arrays.sort(result);
		System.out.println(Arrays.toString(result));
		
	}

	private static int[] getUniqueNumber(int[] a) {
		boolean[] flags = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			flags[i] = false;
			for (int j = 0; j < a.length; j++) {
				if (j != i && a[i] == a[j]) {
					flags[j] = true;
					flags[i] = true;
				}
			}
		}
		int[] result = new int[a.length];
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (!flags[i]) {
				result[count++] = a[i];
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
}
