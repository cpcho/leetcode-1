package bfs;

import java.util.*;

/**
 * 
 * Problem: Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X

 * Algorithm:  
 * 1.starts with all the 'O' on the edges. mark '+'
 * 2.change all + to o,  all o to x
 *
 * Time Complexity: 
 * Space Complexity:
 * 
 */

public class _130_SurroundedRegions {
	private final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };
	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') {
				markBFS(board, 0, i);
			}
			if (board[rows - 1][i] == 'O') {
				markBFS(board, rows - 1, i);
			}
		}
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				markBFS(board, i, 0);
			}
			if (board[i][cols - 1] == 'O') {
				markBFS(board, i, cols - 1);
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '+') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void markBFS(char[][] board, int i, int j) {
		int rows = board.length;
		int cols = board[0].length;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i * cols + j);
		board[i][j] = '+';
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			int row = tmp / cols;
			int col = tmp % cols;
			for (int k = 0; k < 4; k++) {
				int newRow = row + DIRECTIONS[k];
				int newCol = col + DIRECTIONS[k + 1];
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'O') {
					board[newRow][newCol] = '+';
					queue.offer(newRow * cols + newCol);
				}
			}
		}
	}
}