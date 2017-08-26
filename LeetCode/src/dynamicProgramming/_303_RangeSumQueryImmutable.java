package dynamicProgramming;

/**
 * 
 * Problem: Given an integer array nums, find the sum of the elements between
 * indices i and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note: You may
 * assume that the array does not change. There are many calls to sumRange
 * function.
 *
 * Solution:
 * 
 * Time Complexity:
 * 
 * Space Complexity:
 *
 */
public class _303_RangeSumQueryImmutable {
	private int[] dp;

	public _303_RangeSumQueryImmutable(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

	public int sumRange(int i, int j) {
		return dp[j + 1] - dp[i];
	}
}
