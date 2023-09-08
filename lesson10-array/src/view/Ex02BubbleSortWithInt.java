package view;

import java.util.Arrays;

import common.SortDir;
import utils.CompareIntHelper;
import utils.SortUtils;

public class Ex02BubbleSortWithInt {
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 11, 9, 4, 6 };
		
		// anonymous class
		sort(numbers, new CompareIntHelper() {
			
			@Override
			public boolean compare(int pre, int next) {
				return pre > next;
			}
		});
		
		System.out.println("ascending" + Arrays.toString(numbers));
//		
		// anonymous function
		// lamda
		CompareIntHelper helperAsc = (pre, next) -> pre > next;
		
		CompareIntHelper helperDesc = (pre, next) -> {
			return pre < next;
		};
		
		
		sort(numbers, helperAsc);
		System.out.println("ascending: " + Arrays.toString(numbers));
		sort(numbers, helperDesc);
		System.out.println("descending: " + Arrays.toString(numbers));
	}

	// strategy pattern
	private static void sort(int[] source, CompareIntHelper helper) {
		for (int round = 0; round < source.length; round++) {
			for (int j = 0; j < source.length - round - 1; j++) {
				if (helper.compare(source[j], source[j + 1])) {
					SortUtils.swap(source, j, j + 1);
				}
			}
		}
	}
}
