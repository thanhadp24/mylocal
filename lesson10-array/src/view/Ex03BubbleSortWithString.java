package view;

import java.util.Arrays;

import utils.CompareStringHelper;
import utils.SortUtils;

public class Ex03BubbleSortWithString {
	public static void main(String[] args) {
		String[] sequences = { "alex", null, "terry", "rivaldo", null, "blue", "zill", null };
//		sort(sequences);
//		System.out.println("sorted: " + Arrays.toString(sequences));

//		selectionSortKeepCurrentNullValue(sequences);
//		System.out.println("sort keep null value: " + Arrays.toString(sequences));

//		sortHandleNullFirst(sequences);
//		System.out.println("sort handle null value first: " + Arrays.toString(sequences));

//		sortHandleNullLast(sequences, (s1, s2) -> s2.compareTo(s1));
//		System.out.println("sort handle null value last: " + Arrays.toString(sequences));
		
		sort(sequences, new CompareStringHelper() {
			@Override
			public int compare(String s1, String s2) {
				// null last
				if (s1 == null) {
					return 1;
				}

				if (s2 == null) {
					return -1;
				}
				
				return s1.compareTo(s2);
			}
		});
		
		sort(sequences, (s1, s2) -> {
			// null first
			if (s1 == null) {
				return -1;
			}
			
			if (s2 == null) {
				return 1;
			}
			
			return s1.compareTo(s2);
		});
		System.out.println(Arrays.toString(sequences));
	}

	private static void sort(String[] source, CompareStringHelper helper) {
		for (int round = 0; round < source.length; round++) {
			for (int i = 0; i < source.length - 1 - round; i++) {
				if (helper.compare(source[i], source[i + 1]) > 0) {
					SortUtils.swapString(source, i, i + 1);
				}
			}
		}
	}
	
	private static void selectionSortKeepCurrentNullValue(String[] source) {
		for (int i = source.length - 1; i > 0; i--) {
			if (source[i] != null) {
				for (int j = 0; j < i; j++) {
					if (source[j] != null) {
						if (source[j].compareTo(source[i]) > 0) {
							SortUtils.swapString(source, i, j);
						}
					}
				}
			}
		}
	}

	// B1: xử lí nullValue --> nullFirst, nullLast
	// B2: sau đó các phần tử khác null --> sort

	private static void sortHandleNullLast(String[] source, CompareStringHelper helper) {
		for (int round = 0; round < source.length; round++) {
			for (int i = 0; i < source.length - 1 - round; i++) {
				// B1: xử lí null last
				if (source[i] == null && source[i + 1] != null) {
					SortUtils.swapString(source, i, i + 1);
					continue;
				}

				if (source[i + 1] == null) {
					continue;
				}

				// B2: sắp xếp các phần tử khác null --> ascending
				if (helper.compare(source[i], source[i + 1]) > 0) {
					SortUtils.swapString(source, i, i + 1);
				}
			}
		}
	}

	private static void sortHandleNullFirst(String[] source) {
		for (int round = 0; round < source.length; round++) {
			for (int i = 0; i < source.length - 1 - round; i++) {
				// B1: xử lí null First
				if (source[i] == null)
					continue;

				if (source[i + 1] == null) {
					SortUtils.swapString(source, i, i + 1);
					continue;
				}

				// B2: sắp xếp các phần tử khác null --> ascending
				if (source[i].compareTo(source[i + 1]) < 0) {
					SortUtils.swapString(source, i, i + 1);
				}
			}
		}
	}

	

}
