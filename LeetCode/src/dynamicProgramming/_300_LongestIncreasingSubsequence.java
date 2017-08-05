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
		if (nums.length <= 1)
			return nums.length;
		int a[] = new int[nums.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (a[j] + 1 > a[i]) {
						a[i] = a[j] + 1;
					}
				}
			}
		}
		int numLis = 0;
		for (int i = 0; i < a.length; i++) {
			numLis = Math.max(numLis, a[i]);
		}
		return numLis;
	}
}
