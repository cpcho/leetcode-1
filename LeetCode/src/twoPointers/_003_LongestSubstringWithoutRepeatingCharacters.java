package twoPointers;

/**
 * 
 * Problem: Given a string, find the length of the longest substring without
 * repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */

public class _003_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		boolean[] map = new boolean[256];
		int max = 0;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j < s.length() && !map[s.charAt(j)]) {
				map[s.charAt(j)] = true;
				max = Math.max(max, j - i + 1);
				j++;
			}
			map[s.charAt(i)] = false;
		}
		return max;
	}
}