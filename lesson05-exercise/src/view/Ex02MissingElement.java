package view;

import utils.ArrayUtils;

public class Ex02MissingElement {
	public static void main(String[] args) {
		int[] numbers = { 3, 2, 1, 6, 5 };
		System.out.println("missing element: " + findMissingNumber(numbers));
	}

	private static int findMissingNumber(int[] numbers) {
		int found = 0;
		// step 1: sort array of numbers
		ArrayUtils.selectionSort(numbers);
		// step 2: iterate element in array
		ArrayUtils.prinf(numbers);
		// if element[i] != element[i-1]+1 ==> found = element[i-1] + 1

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] - numbers[i - 1] != 1) {
				found = numbers[i - 1] + 1;
				break;
			}
		}
		return found;
	}
}