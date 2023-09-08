package view;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex04UniqueNumber {
	
	public static void main(String[] args) {
		int[] elements = { 3, 15, 21, 0, 17, 21, 15, 69 };
		int[] foundElements = getUnitElement(elements);
		ArrayUtils.prinf(foundElements);
	}

	private static int[] getUnitElement(int[] elements) {
		boolean[] flags = new boolean[elements.length];
		for (int pivotIndex = 0; pivotIndex < elements.length; pivotIndex++) {
			if (flags[pivotIndex] == true)
				continue;

			for (int i = 0; i < elements.length; i++) {
				if (pivotIndex != i && elements[pivotIndex] == elements[i]) {
					flags[i] = true;
					flags[pivotIndex] = true;
				}
			}
		}
		int[] result = new int[elements.length];
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (!flags[i]) {
				result[count++] = elements[i];
			}

		}
		return Arrays.copyOfRange(result, 0, count);
	}
}
