package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Problem: You want to build a house on an empty land which reaches all
 * buildings in the shortest amount of distance. You can only move up, down,
 * left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely. Each 1 marks a
 * building which you cannot pass through. Each 2 marks an obstacle which you
 * cannot pass through. For example, given three buildings at (0,0), (0,4),
 * (2,2), and an obstacle at (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1 
 * |   |   |   |   | 
 * 0 - 0 - 0 - 0 - 0 
 * |   |   |   |   | 
 * 0 - 0 - 1 - 0 - 0 
 * The point (1,2) is an ideal empty land to build a house, as the total travel
 * distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note: There will be at least one building. If it is not possible to build
 * such house according to the above rules, return -1.
 *
 */
public class _317_ShortestDistanceFromAllBuildings {

	private static final int[] POINT = { 0, 1, 0, -1, 0 };

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] distances = new int[rows][cols];
		int[][] reachCounts = new int[rows][cols];
		int buildings = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 1) {
					buildings++;
					Queue<Integer> queue = new LinkedList<>();
					Set<Integer> set = new HashSet<>();
					int index = r * cols + c;
					queue.offer(index);
					set.add(index);
					int curDis = 0;
					while (!queue.isEmpty()) {
						int size = queue.size();
						curDis++;
						for (int i = 0; i < size; i++) {
							index = queue.poll();
							int curRow = index / cols;
							int curCol = index % cols;
							for (int j = 0; j < POINT.length - 1; j++) {
								int newRow = curRow + POINT[j];
								int newCol = curCol + POINT[j + 1];
								if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
										&& grid[newRow][newCol] == 0 && !set.contains(newRow * cols + newCol)) {
									distances[newRow][newCol] += curDis;
									reachCounts[newRow][newCol]++;
									index = newRow * cols + newCol;
									queue.offer(index);
									set.add(index);
								}
							}
						}
					}
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[0].length; j++) {
				if (reachCounts[i][j] == buildings) {
					res = Math.min(res, distances[i][j]);
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
