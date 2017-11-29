package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Problem:
 * 
 * Given an m x n matrix of positive integers representing the height of each
 * unit cell in a 2D elevation map, compute the volume of water it is able to
 * trap after raining.
 * 
 * Note: Both m and n are less than 110. The height of each unit cell is greater
 * than 0 and is less than 20,000.
 * 
 * Example:
 * 
 * Given the following 3x6 height map: [ [1,4,3,1,3,2], [3,2,1,3,2,4],
 * [2,3,3,2,3,1] ]
 * 
 * Return 4.
 *
 */

public class _407_TrappingRainWaterII {
	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
			return 0;
		}
		int res = 0;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, -1, 0, 1 };
		int rows = heightMap.length;
		int cols = heightMap[0].length;
		boolean[][] visited = new boolean[rows][cols];
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comp());
		for (int i = 0; i < rows; i++) {
			pq.offer(new Node(i, 0, heightMap[i][0]));
			pq.offer(new Node(i, cols - 1, heightMap[i][cols - 1]));
			visited[i][0] = true;
			visited[i][cols - 1] = true;
		}
		for (int i = 0; i < cols; i++) {
			pq.offer(new Node(0, i, heightMap[0][i]));
			pq.offer(new Node(rows - 1, i, heightMap[rows - 1][i]));
			visited[0][i] = true;
			visited[rows - 1][i] = true;
		}
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (int i = 0; i < 4; i++) {
				int curR = cur.r + dr[i];
				int curC = cur.c + dc[i];
				if (curR >= 0 && curC >= 0 && curR < rows && curC < cols && !visited[curR][curC]) {
					pq.offer(new Node(curR, curC, Math.max(cur.h, heightMap[curR][curC])));
					res = res + Math.max(0, cur.h - heightMap[curR][curC]);
					visited[curR][curC] = true;
				}
			}
		}
		return res;
	}
}

class Node {
	int r;
	int c;
	int h;

	public Node(int r, int c, int h) {
		this.r = r;
		this.c = c;
		this.h = h;
	}
}

class Comp implements Comparator<Node> {
	@Override
	public int compare(Node x, Node y) {
		if (x.h > y.h) {
			return 1;
		} else if (x.h < y.h) {
			return -1;
		} else {
			return 0;
		}
	}
}