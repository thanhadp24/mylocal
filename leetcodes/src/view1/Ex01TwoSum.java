package view1;

import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. Example: Input: nums =
 * [2,7,11,15], target = 9 Output: [0,1]
 */

public class Ex01TwoSum {

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15, 7 };
		
		int[] result = twoSum(numbers, 9);
		System.out.println("index --> " + Arrays.toString(result));
	}

	private static int[] twoSum(int[] numbers, int target) {

		Map<Integer, Integer> hashMap = new HashMap<>();
		
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			if (hashMap.containsKey(target - num)) {
				return new int[] { hashMap.get(target - num), i };
			}
			hashMap.put(num, i);
		}
		return null;
	}
}
