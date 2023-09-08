package view;

import static java.math.BigDecimal.*;
import static java.math.RoundingMode.*;
import java.util.Arrays;

/**
 * Tạo mảng số nguyên ngẫu nhiên n phần tử.Viết method + loại bỏ phần tử trùng
 * Vd {1,2,3,4,3,1} --> {2,4}
 * 
 * + So sánh giá trị trung bình của n/2 phần tử đầu tiên với n/2 phần tử cuối
 * cùng
 * 
 * + tìm số lớn thứ 3 trong mảng Vd(7,8,8,8,6,5,2) --> 6
 * 
 */

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 3, 5, 5, 9, 1 };

		System.out.println(Arrays.toString(keepNumbersWithoutDuplicated(numbers)));
		System.out.println("=============");

		boolean compare = compareAverageOfHalves(numbers);
		System.out.println(compare);
		System.out.println("=============");

		System.out.println(find3rdLargestWithoutRepeating(numbers));
	}

	// find the third largest number
	private static int find3rdLargestWithoutRepeating(int[] numbers) {
		int first = 0;
		int second = 0;
		int third = 0;

		for (int num : numbers) {
			if (num > first) {
				third = second;
				second = first;
				first = num;
			}
		}

		return third;
	}

	private static boolean compareAverageOfHalves(int[] numbers) {
		int sum1stHalf = 0;
		int sum2ndHalf = 0;

		int length = numbers.length;

		for (int i = 0; i < length; i++) {
			if (i < length / 2) {
				sum1stHalf += numbers[i];
				continue;
			}
			sum2ndHalf += numbers[i];
		}

		int size1stHalf = length / 2;
		int size2ndHalf = length - size1stHalf;

		double average1stHalf = (double) sum1stHalf / size1stHalf;
		double average2ndHalf = (double) sum2ndHalf / size2ndHalf;

		return valueOf(average1stHalf).setScale(2, HALF_UP).compareTo(valueOf(average2ndHalf).setScale(2, HALF_UP)) > 0;

	}

	private static int[] keepNumbersWithoutDuplicated(int[] numbers) {
		int[] result = new int[numbers.length];
		int count = 0;
		boolean[] flags = new boolean[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if (!flags[i]) {
				processIfDuplicate(numbers, i, flags);
			}

			if (!flags[i]) {
				result[count++] = numbers[i];
			}
		}

		return Arrays.copyOfRange(result, 0, count);
	}

	private static void processIfDuplicate(int[] numbers, int checkPos, boolean[] flags) {
		for (int i = 0; i < numbers.length; i++) {
			if (!flags[i] && i != checkPos && numbers[i] == numbers[checkPos]) {
				flags[i] = true;
				flags[checkPos] = true;
			}
		}
	}

}
