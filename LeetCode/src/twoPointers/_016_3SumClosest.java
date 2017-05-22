package twoPointers;

import java.util.Arrays;

/**
 * 
 * Problem: Given an array S of n integers, find three integers in S such that
 * the sum is closest to a given number, target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Algorithm:
 *
 * Time Complexity: O(N2)
 *
 * Space Complexity:
 *
 */
public class _016_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return -1;
		}
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		int sum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
				if (sum - target > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}
}
