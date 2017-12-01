package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example: For the given grid
 * 
 * 0 E 0 0
 * 
 * E 0 W E
 * 
 * 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 *
 */
public class _361_BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int res = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		int rowhits = 0;
		int[] dp = new int[cols]; // record the hits in each col
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == 0 || grid[i][j - 1] == 'W') {
					rowhits = 0;
					for (int k = j; k < cols && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E') {
							rowhits++;
						}
					}
				}
				if (i == 0 || grid[i - 1][j] == 'W') {
					dp[j] = 0;
					for (int k = i; k < rows && grid[k][j] != 'W'; k++) {
						if (grid[k][j] == 'E') {
							dp[j]++;
						}
					}
				}
				if (grid[i][j] == '0') {
					res = Math.max(res, rowhits + dp[j]);
				}
			}
		}
		return res;
	}
}
