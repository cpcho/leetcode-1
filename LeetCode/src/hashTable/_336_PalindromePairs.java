package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem: Given a list of unique words, find all pairs of distinct indices (i,
 * j) in the given list, so that the concatenation of the two words, i.e.
 * words[i] + words[j] is a palindrome.
 * 
 * Example 1: Given words = ["bat", "tab", "cat"] Return [[0, 1], [1, 0]] The
 * palindromes are ["battab", "tabbat"] 
 * 
 * Example 2: Given words = ["abcd",
 * "dcba", "lls", "s", "sssll"] Return [[0, 1], [1, 0], [3, 2], [2, 4]] The
 * palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * Solution: HashMap, key: String, value: index
 *
 */
public class _336_PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String left = words[i].substring(0, j);
				String right = words[i].substring(j);
				if (isPalindrome(left)) {
					String rightReverse = new StringBuilder(right).reverse().toString();
					if (map.containsKey(rightReverse) && map.get(rightReverse) != i) {
						List<Integer> list = new ArrayList<>();
						list.add(map.get(rightReverse));
						list.add(i);
						res.add(list);
					}
				}
				if (isPalindrome(right)) {
					String leftReverse = new StringBuilder(left).reverse().toString();
					// duplicate abcd, dcba right.length() != 0
					if (map.containsKey(leftReverse) && map.get(leftReverse) != i && right.length() != 0) {
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(map.get(leftReverse));
						res.add(list);
					}
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}
}
