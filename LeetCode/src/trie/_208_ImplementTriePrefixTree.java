package trie;

/**
 * 
 * Problem: Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 * Solution:
 * 
 * Time Complexity:
 * 
 * Space Complexity:
 *
 */
public class _208_ImplementTriePrefixTree {

	private TrieNode root;

	public _208_ImplementTriePrefixTree() {
		root = new TrieNode();
	}

	public void insert(String word) {
		root.insert(word, 0);
	}

	public boolean search(String word) {
		TrieNode node = root.find(word, 0);
		return (node != null && node.isEnd);
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root.find(prefix, 0);
		return node != null;
	}
}

class TrieNode {
	private TrieNode[] children;
	public boolean isEnd;

	public TrieNode() {
		children = new TrieNode[26];
		isEnd = false;
	}

	// index is used to iterate the whole string word recursion
	public void insert(String word, int index) {
		// empty string
		if (index == word.length()) {
			this.isEnd = true;
			return;
		}
		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			children[pos] = new TrieNode();
		}
		children[pos].insert(word, index + 1);
	}

	// recursion
	public TrieNode find(String word, int index) {
		if (index == word.length()) {
			return this;
		}
		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			return null;
		}
		return children[pos].find(word, index + 1);
	}
}