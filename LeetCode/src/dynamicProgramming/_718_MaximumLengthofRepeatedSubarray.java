package dynamicProgramming;

/**
 * 
 * Problem:
 *
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1: Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The
 * repeated subarray with maximum length is [3, 2, 1]. Note: 1 <= len(A), len(B)
 * <= 1000 0 <= A[i], B[i] < 100
 * 
 */
public class _718_MaximumLengthofRepeatedSubarray {
	public int findLength(int[] A, int[] B) {
		int max = 0;
		int lenA = A.length;
		int lenB = B.length;
		int[][] dp = new int[lenA + 1][lenB + 1];
		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > max) {
						max = dp[i][j];
					}
				}
			}
		}
		return max;
	}
}
