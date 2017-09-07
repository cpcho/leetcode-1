package hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem: Given a string s and a non-empty string p, find all the start
 * indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc". Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 *
 */
public class _438_FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i <= s.length() - p.length(); i++) {
			if (isAnagram(s.substring(i, i + p.length()), p)) {
				res.add(i);
			}
		}
		return res;
	}

	private boolean isAnagram(String s1, String s2) {
		int[] map = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			map[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (--map[s2.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
