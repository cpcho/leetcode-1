package hashTable;

import java.util.Arrays;

/**
 * 
 * Problem:
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 * 
 */
public class _205_IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		int[] map = new int[512];
		Arrays.fill(map, -1);
		for (int i = 0; i < c1.length; i++) {
			if (map[c1[i]] == -1) {
				map[c1[i]] = c2[i];
			} else {
				if (map[c1[i]] != c2[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
