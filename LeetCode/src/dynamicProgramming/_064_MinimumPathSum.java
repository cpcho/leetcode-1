package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 *
 */
public class _064_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;

		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] map = new int[m][n];
		map[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			map[0][i] = map[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			map[i][0] = map[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = Math.min(map[i][j - 1], map[i - 1][j]) + grid[i][j];

			}
		}
		return map[m - 1][n - 1];
	}
}
