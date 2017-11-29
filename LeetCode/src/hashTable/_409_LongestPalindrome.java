package hashTable;

/**
 * 
 * Problem:
 * 
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 *
 */
public class _409_LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] map = new int[256];
		int len = s.length();
		int res = 0;
		for (int i = 0; i < len; i++) {
			map[s.charAt(i)]++;
		}
		for (int i : map) {
			res += i / 2 * 2;
		}
		return res == len ? res : res + 1;
	}
}
