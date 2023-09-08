package view1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1: Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation:
 * merged array = [1,2,3] and median is 2.
 */

public class Ex13MedianTwoSortedArrays {
	public static void main(String[] args) {
		int[] num1 = { 1, 3 };
		int[] num2 = { 2, 4 };

		System.out.println(findMedianSortedArrays(num1, num2));
	}

	private static double findMedianSortedArrays(int[] num1, int[] num2) {
		int n1 = num1.length;
		int n2 = num2.length;
		int length = n1 + n2;

		int[] num = new int[length];

		int i = 0, j = 0, k = 0;

		while (i <= n1 && j <= n2) {
			if (num1[i] < num2[j]) {
				num[k++] = num1[i++];
			} else {
				num[k++] = num2[j++];
			}

			if (i == n1) {
				while (j < n2) {
					num[k++] = num2[j++];
				}
				break;
			} 
			
			if (j == n2) {
				while (i < n1) {
					num[k++] = num1[i++];
				}
				break;
			}

		}

		if (length % 2 != 0) {
			return num[length / 2];
		} else {
			return (num[length / 2] + num[length / 2 - 1]) / 2.0;
		}

	}
}
