package trie;

import java.util.List;

/**
 * 
 * Problem:
 *
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor. For
 * example, the root an, followed by other, which can form another word another.
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * You need to output the sentence after the replacement.
 * 
 * Example 1:
 * 
 * Input: dict = ["cat", "bat", "rat"] sentence =
 * "the cattle was rattled by the battery"
 * 
 * Output: "the cat was rat by the bat"
 * 
 * Note: The input will only have lower-case letters.
 * 
 * 1 <= dict words number <= 1000
 * 
 * 1 <= sentence words number <= 1000
 * 
 * 1 <= root length <= 100
 * 
 * 1 <= sentence words length <= 1000
 */
public class _648_ReplaceWords {
	class TrieNode {
		char val;
		TrieNode[] children;
		boolean isWord;

		TrieNode(char val) {
			this.val = val;
			children = new TrieNode[26];
			isWord = false;
		}
	}

	public String replaceWords(List<String> dict, String sentence) {
		String[] strs = sentence.split(" ");
		TrieNode trie = buildTrie(dict);
		StringBuilder res = new StringBuilder();
		for (String s : strs) {
			res.append(replace(s, trie) + " ");
		}
		return res.substring(0, res.length() - 1);
	}

	private TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode('#');
		for (String word : dict) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				if (cur.children[c - 'a'] == null) {
					cur.children[c - 'a'] = new TrieNode(c);
				}
				cur = cur.children[c - 'a'];
			}
			cur.isWord = true;
		}
		return root;
	}

	private String replace(String s, TrieNode root) {
		TrieNode cur = root;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(c);
			if (cur.children[c - 'a'] != null) {
				if (cur.children[c - 'a'].isWord) {
					return sb.toString();
				}
				cur = cur.children[c - 'a'];
			} else {
				return s;
			}
		}
		return s;
	}
}
