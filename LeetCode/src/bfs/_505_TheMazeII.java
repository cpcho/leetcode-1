package bfs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem: 
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can
 * go through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction.
 * 
 * Given the ball's start position, the destination and the maze, find the
 * shortest distance for the ball to stop at the destination. The distance is
 * defined by the number of empty spaces traveled by the ball from the start
 * position (excluded) to the destination (included). If the ball cannot stop at
 * the destination, return -1.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column
 * indexes.
 * 
 * Example 1
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0 
 * 0 0 0 0 0 
 * 0 0 0 1 0 
 * 1 1 0 1 1 
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4) 
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * 
 * Output: 12 Explanation: One shortest way is : left -> down -> left -> down ->
 * right -> down -> right. The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * 
 * Example 2
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0 
 * 0 0 0 0 0 
 * 0 0 0 1 0 
 * 1 1 0 1 1 
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4) 
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * 
 * Output: -1 Explanation: There is no way for the ball to stop at the
 * destination.
 * 
 * Note: There is only one ball and one destination in the maze. Both the ball
 * and the destination exist on an empty space, and they will not be at the same
 * position initially. The given maze does not contain border (like the red
 * rectangle in the example pictures), but you could assume the border of the
 * maze are all walls. The maze contains at least 2 empty spaces, and both the
 * width and height of the maze won't exceed 100.
 * 
 */

public class _505_TheMazeII {
	class Point {
		int row, col, len;

		public Point(int row, int col, int len) {
			this.row = row;
			this.col = col;
			this.len = len;
		}
	}

	private static final int[] POINT = { 0, 1, 0, -1, 0 };

	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int rows = maze.length;
		int cols = maze[0].length;
		int[][] length = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				length[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Point> pq = new PriorityQueue<>((a, b) -> a.len - b.len);
		pq.offer(new Point(start[0], start[1], 0));
		while (!pq.isEmpty()) {
			Point tmp = pq.poll();
			if (length[tmp.row][tmp.col] <= tmp.len) {
				continue;
			}
			length[tmp.row][tmp.col] = tmp.len;
			for (int i = 0; i < 4; i++) {
				int row = tmp.row;
				int col = tmp.col;
				int len = tmp.len;
				while (row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == 0) {
					row += POINT[i];
					col += POINT[i + 1];
					len++;
				}
				row -= POINT[i];
				col -= POINT[i + 1];
				len--;
				pq.offer(new Point(row, col, len));
			}
		}
		return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
				: length[destination[0]][destination[1]];
	}
}
