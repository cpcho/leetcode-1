package twoPointers;

import java.util.HashMap;
import java.util.Map;

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
 */

public class _003_LongestSubstringWithoutRepeatingCharacters {
	// Method 1
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>(); // char -> index
		int len = s.length();
		int left = 0;
		int max = 0;
		for (int right = 0; right < len; right++) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(left, map.get(s.charAt(right)));
			}
			max = Math.max(max, right - left + 1);
			map.put(s.charAt(right), right + 1);
		}
		return max;
	}

	// Method 1
	public int lengthOfLongestSubstring1(String s) {
		boolean[] map = new boolean[256];
		int max = 0;
		int right = 0;
		for (int left = 0; left < s.length(); left++) {
			while (right < s.length() && !map[s.charAt(right)]) {
				map[s.charAt(right)] = true;
				max = Math.max(max, right - left + 1);
				right++;
			}
			map[s.charAt(left)] = false;
		}
		return max;
	}

}