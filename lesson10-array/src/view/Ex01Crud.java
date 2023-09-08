package view;

import java.util.Arrays;

public class Ex01Crud {
	public static void main(String[] args) {
		int[] numbers = { 1, 9, 5, 36, 12, 33 };
		System.out.println(Arrays.toString(add(numbers, 2, 0)));

//		System.out.println(Arrays.toString(insert(numbers, 2, 0)));
//
//		System.out.println("remove: " + Arrays.toString(remove(numbers, 2)));
		System.out.println("remove: " + Arrays.toString(delete1Element(numbers, 2)));
	}

	private static int[] insert(int[] source, int pos, int newValue) {
		int[] target = new int[source.length + 1];
		for (int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}

		for (int i = target.length - 1; i > pos; i--) {
			target[i] = target[i - 1];
		}
		target[pos] = newValue;

		return target;
	}

	private static int[] add(int[] source, int pos, int newValue) {
		int[] target = new int[source.length + 1];
		for (int i = 0; i <= source.length; i++) {
			if (i < pos) {
				target[i] = source[i];
			} else if (i == pos) {
				target[i] = newValue;
			} else {
				target[i] = source[i - 1];
			}
		}
		return target;
	}

	// c2 move
	private static int[] delete1Element(int[] elements, int pos) {
		int length = elements.length;

		for (int i = pos; i < length - 1; i++) {
				elements[i] = elements[i + 1];
			
		}
		return Arrays.copyOfRange(elements, 0, length - 1);
	}
	
	
	// c1 copy
	private static int[] remove(int[] elements, int pos) {
		int[] result = new int[elements.length - 1];
		for (int i = 0; i < elements.length; i++) {
			if (i < pos) {
				result[i] = elements[i];
			} else if (i == pos) {
				continue;
			} else {
				result[i - 1] = elements[i];
			}
		}
		return result;
	}
}
