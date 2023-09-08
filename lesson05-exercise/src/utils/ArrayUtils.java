package utils;

public class ArrayUtils {
	private ArrayUtils() {

	}

	public static void prinf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void selectionSort(int[] elements) {
		for (int i = elements.length - 1; i > 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (elements[j] > elements[i]) {
					int tmp = elements[j];
					elements[j] = elements[i];
					elements[i] = tmp;
				}
			}
		}

	}
}
