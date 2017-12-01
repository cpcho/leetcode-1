package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0
 * 
 * 0 1 0 1
 * 
 * 1 1 1 1
 * 
 * 1 1 1 1
 * 
 * 0 0 1 0
 * 
 * Return 4.
 *
 */
public class _221_MaximalSquare {
	/**
	 * Method 1
	 */
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (matrix[i - 1][j - 1] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}

	/**
	 * Method 2
	 */
	public int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[2][cols + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (matrix[i - 1][j - 1] == '0') {
					dp[i % 2][j] = 0;
				} else {
					dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j])) + 1;
					max = Math.max(max, dp[i % 2][j]);
				}
			}
		}
		return max * max;
	}
}
