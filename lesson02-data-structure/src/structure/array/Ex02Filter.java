package structure.array;

import java.util.Arrays;

/**
 * 1. Tìm những phần tử lẻ trong mảng nguyên
 * 	  Input: Mảng
 * 	  Output: Mảng số lẻ
 *
 */
public class Ex02Filter {
	public static void main(String[] args) {
		int[] numbers = {23, 15, 69, 96, 16};
		int[] oddNumbers = findOddNumbers(numbers);
		System.out.println(Arrays.toString(oddNumbers));
	}
	
	private static int[] findOddNumbers(int[] elements) {
		// value: 0 0 0 0 0 
		int[] oddElements = new int[elements.length];
		int count = 0;
		for(int element: elements ) {
			if(element % 2 != 0) {
				oddElements[count] = element;
				count++;
			}
		}
		int[] result = new int[count];
		for(int i = 0; i < count; i++) {
			result[i] = oddElements[i];
		}
		return result;
	}
}
