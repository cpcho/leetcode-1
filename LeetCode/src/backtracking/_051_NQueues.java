package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chess board
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 *
 */
public class _051_NQueues {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		dfs(board, 0, res);
		return res;
	}

	private void dfs(char[][] board, int col, List<List<String>> res) {
		if (col == board[0].length) {
			res.add(getString(board));
		}
		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, col)) {
				board[i][col] = 'Q';
				dfs(board, col + 1, res);
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

	private List<String> getString(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			String cur = new String(board[i]);
			res.add(cur);
		}
		return res;
	}
}
