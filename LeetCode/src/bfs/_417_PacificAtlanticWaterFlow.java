package bfs;

import java.util.*;

/**
 * 
 * Problem: 
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:
Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * 
 * Algorithm: 
 * 1. Both pacific and Atlantic have a Queue and a Matrix. 
 * 2. BFS and updata the visited Matrix.
 * 3. find the points which are true in both P and A
 * Time Complexity: 
 *
 * Space Complexity:
 */

public class _417_PacificAtlanticWaterFlow {
	private static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null | matrix.length == 0) {
			return res;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] pacific = new boolean[rows][cols];
		boolean[][] atalantic = new boolean[rows][cols];
		Queue<Integer> queueP = new LinkedList<>();
		Queue<Integer> queueA = new LinkedList<>();
		for (int i = 0; i < rows; i++) {
			queueP.offer(i * cols);
			queueA.offer((i + 1) * cols - 1);
			pacific[i][0] = true;
			atalantic[i][cols - 1] = true;
		}
		for (int i = 0; i < cols; i++) {
			queueP.offer(i + 0);
			queueA.offer(cols * (rows - 1) + i);
			pacific[0][i] = true;
			atalantic[rows - 1][i] = true;
		}
		markBFS(matrix, queueP, pacific);
		markBFS(matrix, queueA, atalantic);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (pacific[i][j] && atalantic[i][j]) {
					res.add(new int[] { i, j });
				}
			}
		}
		return res;
	}

	private void markBFS(int[][] matrix, Queue<Integer> queue, boolean[][] visited) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			int row = tmp / cols;
			int col = tmp % cols;
			for (int i = 0; i < 4; i++) {
				int newRow = row + DIRECTIONS[i];
				int newCol = col + DIRECTIONS[i + 1];
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
						&& matrix[newRow][newCol] >= matrix[row][col]) {
					visited[newRow][newCol] = true;
					queue.offer(newRow * cols + newCol);
				}
			}
		}
	}
}