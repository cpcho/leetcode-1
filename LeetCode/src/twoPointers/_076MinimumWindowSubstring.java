package twoPointers;

/**
 * 
 * Problem:
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example,
 * 
 * S = "ADOBECODEBANC"
 * 
 * T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 */
public class _076MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int min = Integer.MAX_VALUE;
		String res = "";
		int[] map = new int[256];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int targetNum = t.length();
		int sourceNum = 0;
		// j is the left boundary
		int j = 0, i = 0;
		for (i = 0; i < s.length(); i++) {
			if (map[s.charAt(i)] > 0) {
				sourceNum++;
			}
			map[s.charAt(i)]--;
			// get an substring
			while (sourceNum >= targetNum) {
				if (min > i - j + 1) {
					min = i - j + 1;
					res = s.substring(j, i + 1);
				}
				map[s.charAt(j)]++;
				if (map[s.charAt(j)] > 0) {
					sourceNum--;
				}
				j++;
			}
		}
		return res;
	}
}