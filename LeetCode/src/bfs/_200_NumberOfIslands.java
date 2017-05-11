package bfs;

import java.util.*;

/**
 * 
 * Problem: Given a 2d grid map of '1's (land) and '0's (water), count the
 * number of islands. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four
 * edges of the grid are all surrounded by water. 
 * Time Complexity:
 * Space Complexity:
 */
public class _200_NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					updateGrid(grid, i, j);
					res++;
				}
			}
		}
		return res;
	}

	// BFS
	// change all the points connected with the source point to be 0;
	private void updateGrid(char[][] grid, int row, int col) {
		grid[row][col] = '0';
		int rows = grid.length;
		int cols = grid[0].length;
		int index = row * cols + col;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);
		while (!queue.isEmpty()) {
			index = queue.poll();
			row = index / cols;
			col = index % cols;
			// up
			if (row > 0 && grid[row - 1][col] == '1') {
				queue.offer((row - 1) * cols + col);
				grid[row - 1][col] = '0';
			}
			// down
			if (row < rows - 1 && grid[row + 1][col] == '1') {
				queue.offer((row + 1) * cols + col);
				grid[row + 1][col] = '0';
			}
			// left
			if (col > 0 && grid[row][col - 1] == '1') {
				queue.offer(row * cols + col - 1);
				grid[row][col - 1] = '0';
			}
			// right
			if (col < cols - 1 && grid[row][col + 1] == '1') {
				queue.offer(row * cols + col + 1);
				grid[row][col + 1] = '0';
			}
		}
	}
}