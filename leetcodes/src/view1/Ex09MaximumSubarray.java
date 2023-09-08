package view1;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray
 * [4,-1,2,1] has the largest sum 6.
 */

public class Ex09MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(getMaxSubArray(nums));
	}

	private static int getMaxSubArray(int[] nums) {

		int max = nums[0];
		int sum = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], nums[i] + sum);
			max = Math.max(max, sum);
		}

		return max;
	}
}
