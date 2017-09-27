package trie;

/**
 * 
 * Problem: 
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") 
 * addWord("dad") 
 * addWord("mad") 
 * search("pad") -> false
 * search("bad") -> true 
 * search(".ad") -> true 
 * search("b..") -> true Note: You
 * may assume that all words are consist of lowercase letters a-z.
 *
 */
public class _211_AddAndSearchWordDataStructureDesign {
	class Trie {
		public Trie[] children;
		public boolean isEnd;

		public Trie() {
			children = new Trie[26];
			isEnd = false;
		}
	}

	private Trie root;

	public _211_AddAndSearchWordDataStructureDesign() {
		root = new Trie();
	}

	public void addWord(String word) {
		Trie cur = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new Trie();
			}
			cur = cur.children[index];
		}
		cur.isEnd = true;
	}

	public boolean search(String word) {
		return helper(word.toCharArray(), 0, root);
	}

	private boolean helper(char[] ch, int k, Trie cur) {
		if (k == ch.length) {
			if (cur.isEnd) {
				return true;
			} else {
				return false;
			}
		}
		// a-z
		if (ch[k] != '.') {
			if (cur.children[ch[k] - 'a'] == null) {
				return false;
			} else {
				return helper(ch, k + 1, cur.children[ch[k] - 'a']);
			}
		} else {
			// '.'
			for (int i = 0; i < 26; i++) {
				if (cur.children[i] != null) {
					/** tricky part. should not use return helper(ch, k + 1, cur.children[i]) directly
					 get the match. then return. if not. it will only return
					 when it meet cur.children[i] != null
					 */
					if (helper(ch, k + 1, cur.children[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
