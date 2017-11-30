package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'], ['i','f','l','v']
 * ] Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 *
 */

public class _212_WordSearchII {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				helper(board, root, i, j, res);
			}
		}
		return res;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode cur = root;
			for (char c : s.toCharArray()) {
				int i = c - 'a';
				if (cur.children[i] == null) {
					cur.children[i] = new TrieNode();
				}
				cur = cur.children[i];
			}
			cur.word = s;
		}
		return root;
	}

	// backtracking
	private void helper(char[][] board, TrieNode cur, int i, int j, List<String> res) {
		char c = board[i][j];
		if (c == '#' || cur.children[c - 'a'] == null) {
			return;
		}
		cur = cur.children[c - 'a'];
		if (cur.word != null) {
			res.add(cur.word);
			// duplicate
			cur.word = null;
		}
		// mark
		board[i][j] = '#';
		if (i > 0) {
			helper(board, cur, i - 1, j, res);
		}
		if (j > 0) {
			helper(board, cur, i, j - 1, res);
		}
		if (i < board.length - 1) {
			helper(board, cur, i + 1, j, res);
		}
		if (j < board[0].length - 1) {
			helper(board, cur, i, j + 1, res);
		}
		board[i][j] = c;
	}
}
