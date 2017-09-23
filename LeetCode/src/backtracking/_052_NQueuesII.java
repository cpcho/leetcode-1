package backtracking;

/**
 * 
 * Problem:
 * 
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 *
 */
public class _052_NQueuesII {
	private static int count = 0;

	public int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		dfs(board, 0);
		return count;
	}

	private void dfs(char[][] board, int col) {
		if (col == board[0].length) {
			count++;
		}
		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, col)) {
				board[i][col] = 'Q';
				dfs(board, col + 1);
				board[i][col] = '.';
			}
		}
	}

	private boolean validate(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'Q' && (i + j == row + col || i + col == j + row || i == row)) {
					return false;
				}
			}
		}
		return true;
	}
}
