package unionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Problem: A 2d grid map of m rows and n columns is initially filled with
 * water. We may perform an addLand operation which turns the water at position
 * (rows, cols) into a land. Given a list of positions to operate, count the
 * number of islands after each addLand operation. An island is surrounded by
 * water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 *Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water 
and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?:
 *
 */
public class _305_NumberOfIslandsII {
	int[] parent;
	Set<Integer> set = new HashSet<>();
	int rows;
	int cols;

	public void union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		if (parentI != parentJ) {
			parent[parentJ] = parentI;
			set.remove(parentJ);
		}
	}

	public int find(int i) {
		if (i == parent[i]) {
			return i;
		}
		parent[i] = find(i);
		return parent[i];
	}

	public void add(int x, int y) {
		parent[x * cols + y] = x * cols + y;
		set.add(x * cols + y);
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] dir : dirs) {
			int x1 = x + dir[0];
			int y1 = y + dir[1];
			if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && parent[x1 * cols + y1] != -1) {
				union(x1 * cols + y1, x * cols + y);
			}
		}
	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		parent = new int[m * n];
		rows = m;
		cols = n;
		for (int i = 0; i < m * n; i++) {
			parent[i] = -1;
		}
		List<Integer> res = new ArrayList<>();
		for (int[] position : positions) {
			add(position[0], position[1]);
			res.add(set.size());
		}
		return res;
	}
}
