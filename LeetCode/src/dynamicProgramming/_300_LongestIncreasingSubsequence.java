package dynamicProgramming;

/**
 * 
 * Problem: Given an unsorted array of integers, find the length of longest
 * increasing subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class _300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int max = 0;
		int[] dp = new int[len];
		for (int r = 0; r < len; r++) {
			dp[r] = 1;
			for (int l = 0; l < r; l++) {
				if (nums[l] < nums[r]) {
					if (dp[r] < dp[l] + 1) {
						dp[r] = dp[l] + 1;
					}
				}
			}
			max = Math.max(max, dp[r]);
		}
		return max;
	}
}
