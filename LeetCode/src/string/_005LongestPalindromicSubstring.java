package string;

/**
 * 
 * Problem:
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 *
 */
public class _005LongestPalindromicSubstring {
	public class Solution {
		public String longestPalindrome(String s) {
			int left = 0;
			int right = 0;
			for (int i = 0; i < s.length(); i++) {
				int len1 = expandAroundCenter(s, i, i); // odd
				int len2 = expandAroundCenter(s, i, i + 1); // even
				int len = Math.max(len1, len2);
				if (len > right - left) {
					left = i - (len - 1) / 2;
					right = i + len / 2;
				}
			}
			return s.substring(left, right + 1);
		}

		private int expandAroundCenter(String s, int left, int right) {
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			return right - left - 1;
		}
	}
}
