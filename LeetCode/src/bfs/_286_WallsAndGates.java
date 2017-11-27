package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Problem:
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * 1. -1 - A wall or an obstacle.
 * 
 * 2. 0 - A gate.
 * 
 * 3.INF - Infinity means an empty room.
 * 
 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
 * the distance to a gate is less than 2147483647. Fill each empty room with the
 * distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 *
 * For example, given the 2D grid:
 * 
 * INF -1 0 INF
 * 
 * INF INF INF -1
 * 
 * INF -1 INF -1
 * 
 * 0 -1 INF INF
 * 
 * After running your function, the 2D grid should be:
 * 
 * 3 -1 0 1
 * 
 * 2 2 1 -1
 * 
 * 1 -1 2 -1
 * 
 * 0 -1 3 4
 *
 */
public class _286_WallsAndGates {
	private static final int[] POINT = { 0, 1, 0, -1, 0 };

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0) {
			return;
		}
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					markBFS(rooms, i, j);
				}
			}
		}
	}

	private void markBFS(int[][] rooms, int i, int j) {
		int rows = rooms.length;
		int cols = rooms[0].length;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i * cols + j);
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			int row = tmp / cols;
			int col = tmp % cols;
			for (int k = 0; k < 4; k++) {
				int newRow = row + POINT[k];
				int newCol = col + POINT[k + 1];
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
						&& rooms[newRow][newCol] > rooms[row][col] + 1) {
					rooms[newRow][newCol] = rooms[row][col] + 1;
					queue.offer(newRow * cols + newCol);
				}
			}
		}
	}
}
