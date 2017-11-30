package string;

/**
 * 
 * Problem:
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * Example 1: Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * 
 * Example 2: Input: "aba"
 * 
 * Output: False
 * 
 * Example 3: Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 *
 */
public class _459_RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		for (int i = len / 2; i >= 1; i--) {
			// len of substing must be a divisor
			if (len % i == 0) {
				int m = len / i;
				String sub = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(sub);
				}
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;
	}
}
