package hashTable;

import java.util.Arrays;

/**
 * 
 * Problem:
 * 
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 *
 */
public class _242_ValidAnagram {
	/**
	 * 
	 * Method 1: Hash Table
	 */
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		int len1 = s.length();
		int len2 = t.length();
		if (len1 != len2) {
			return false;
		}
		int[] map = new int[26];
		for (int i = 0; i < len1; i++) {
			map[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < len2; i++) {
			if (--map[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * Method 2: Sort
	 */
	public boolean isAnagram2(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		char[] char1 = s.toCharArray();
		char[] char2 = t.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		return Arrays.equals(char1, char2);
	}
}
