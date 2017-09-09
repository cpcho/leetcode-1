package bfs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem: There is a ball in a maze with empty spaces and walls. The ball can
 * go through empty spaces by rolling up (u), down (d), left (l) or right (r),
 * but it won't stop rolling until hitting a wall. When the ball stops, it could
 * choose the next direction. There is also a hole in this maze. The ball will
 * drop into the hole if it rolls on to the hole.
 * 
 * Given the ball position, the hole position and the maze, find out how the
 * ball could drop into the hole by moving the shortest distance. The distance
 * is defined by the number of empty spaces traveled by the ball from the start
 * position (excluded) to the hole (included). Output the moving directions by
 * using 'u', 'd', 'l' and 'r'. Since there could be several different shortest
 * ways, you should output the lexicographically smallest way. If the ball
 * cannot reach the hole, output "impossible".
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The ball and the hole coordinates are represented by row and column indexes.
 * 
 * Example 1
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 0 0 0 
 * 1 1 0 0 1 
 * 0 0 0 0 0 
 * 0 1 0 0 1 
 * 0 1 0 0 0
 * 
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3) 
 * Input 3: hole coordinate (rowHole, colHole) = (0, 1)
 * 
 * Output: "lul" Explanation: There are two shortest ways for the ball to drop
 * into the hole. The first way is left -> up -> left, represented by "lul". The
 * second way is up -> left, represented by 'ul'. Both ways have shortest
 * distance 6, but the first way is lexicographically smaller because 'l' < 'u'.
 * So the output is "lul".
 * 
 * Example 2
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 0 0 0 
 * 1 1 0 0 1 
 * 0 0 0 0 0 
 * 0 1 0 0 1 
 * 0 1 0 0 0
 * 
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3) 
 * Input 3: hole coordinate (rowHole, colHole) = (3, 0) 
 * Output: "impossible" Explanation: The ball cannot reach the hole.
 * 
 * Note: There is only one ball and one hole in the maze. Both the ball and hole
 * exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example
 * pictures), but you could assume the border of the maze are all walls. The
 * maze contains at least 2 empty spaces, and the width and the height of the
 * maze won't exceed 30.
 *
 */
public class _499_TheMazeIII {
	class Point implements Comparable<Point> {
		int row, col, len;
		String s;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
			this.len = Integer.MAX_VALUE;
			this.s = "";
		}

		public Point(int row, int col, int len, String s) {
			this.row = row;
			this.col = col;
			this.len = len;
			this.s = s;
		}

		public int compareTo(Point p) {
			if (len == p.len) {
				return s.compareTo(p.s);
			} else {
				return len - p.len;
			}
		}
	}

	private static final int[] POINT = { 0, 1, 0, -1, 0 };

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		int rows = maze.length;
		int cols = maze[0].length;
		Point[][] points = new Point[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				points[i][j] = new Point(i, j);
			}
		}
		String[] ds = new String[] { "r", "d", "l", "u" };
		Queue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(ball[0], ball[1], 0, ""));
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (points[p.row][p.col].compareTo(p) <= 0) {
				continue; // we have found a shorter route
			}
			points[p.row][p.col] = p;
			for (int i = 0; i < 4; i++) {
				int row = p.row;
				int col = p.col;
				int len = p.len;
				while (row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == 0
						&& (row != hole[0] || col != hole[1])) {
					row += POINT[i];
					col += POINT[i + 1];
					len++;
				}
				if (row != hole[0] || col != hole[1]) {
					row -= POINT[i];
					col -= POINT[i + 1];
					len--;
				}
				pq.offer(new Point(row, col, len, p.s + ds[i]));
			}
		}
		return points[hole[0]][hole[1]].len == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].s;
	}
}
