package backtracking;

/**
 * 
 * Problem: Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ['A','B','C','E'], 
 *   ['S','F','C','S'], 
 *   ['A','D','E','E'] ] word = "ABCCED",
 * -> returns true, word = "SEE", -> returns true, word = "ABCB", -> returns
 * false.
 *
 */
public class _079_WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		char[] ch = word.toCharArray();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (helper(board, ch, row, col, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, char[] ch, int col, int row, int start) {
		if (start == ch.length) {
			return true;
		}
		if (col < 0 || row < 0 || col >= board.length || row >= board[0].length) {
			return false;
		}
		if (board[col][row] != ch[start]) {
			return false;
		}
		// mask
		board[col][row] ^= 256;
		boolean exist = helper(board, ch, col, row + 1, start + 1) || helper(board, ch, col, row - 1, start + 1)
				|| helper(board, ch, col + 1, row, start + 1) || helper(board, ch, col - 1, row, start + 1);
		board[col][row] ^= 256;
		return exist;
	}
}
