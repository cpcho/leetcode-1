package dynamicProgramming;

/**
 * 
 * Problem:
 *
 * Given an unsorted array of integers, find the number of longest increasing
 * subsequence.
 * 
 * Example 1: Input: [1,3,5,4,7]
 * 
 * Output: 2 Explanation: The two longest increasing subsequence are [1, 3, 4,
 * 7] and [1, 3, 5, 7].
 * 
 * Example 2: Input: [2,2,2,2,2]
 * 
 * Output: 5 Explanation: The length of longest continuous increasing
 * subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * 
 * Note: Length of the given array will be not exceed 2000 and the answer is
 * guaranteed to be fit in 32-bit signed int.
 * 
 */
public class _673_NumberofLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		int len = nums.length;
		int maxL = 0;
		int res = 0;
		int[] lenDp = new int[len];
		int[] count = new int[len];
		for (int r = 0; r < len; r++) {
			lenDp[r] = 1;
			count[r] = 1;
			for (int l = 0; l < r; l++) {
				if (nums[l] < nums[r]) {
					if (lenDp[r] == lenDp[l] + 1) {
						count[r] += count[l];
					}
					if (lenDp[r] < lenDp[l] + 1) {
						lenDp[r] = lenDp[l] + 1;
						count[r] = count[l];
					}
				}
			}
			if (maxL == lenDp[r]) {
				res += count[r];
			}
			if (maxL < lenDp[r]) {
				maxL = lenDp[r];
				res = count[r];
			}
		}
		return res;
	}
}
