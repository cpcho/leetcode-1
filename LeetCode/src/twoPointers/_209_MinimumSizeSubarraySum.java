package twoPointers;

/**
 * 
 * Problem: Given an array of n positive integers and a positive integer s, find
 * the minimal length of a contiguous subarray of which the sum ≥ s. If there
 * isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */

public class _209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		int j = 0;
		int sum = 0;
		boolean has = false;
		for (int i = 0; i < nums.length; i++) {
			while (j < nums.length && sum < s) {
				sum += nums[j];
				j++;
			}
			if (sum >= s) {
				has = true;
				res = Math.min(res, j - i);
				sum -= nums[i];
			}
		}
		if (!has) {
			return 0;
		}
		return res;
	}
}