package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given a string, find the length of the longest substring T that
 * contains at most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 *
 */
public class _340_LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int right = 0;
		for (int left = 0; left < s.length(); left++) {
			while (right < s.length()) {
				char newChar = s.charAt(right);
				if (map.containsKey(newChar)) {
					map.put(newChar, map.get(newChar) + 1);
				} else {
					if (map.size() == k) {
						break;
					}
					map.put(newChar, 1);
				}
				right++;
			}
			max = Math.max(max, right - left);
			char oldChar = s.charAt(left);
			if (map.containsKey(oldChar)) {
				int count = map.get(oldChar);
				if (count > 1) {
					map.put(oldChar, count - 1);
				} else {
					map.remove(oldChar);
				}
			}
		}
		return max;
	}
}
