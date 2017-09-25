package string;

/**
 * 
 * Problem:
 * 
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 * 
 * Example 1: Input: "aba" Output: True
 * 
 * Example 2: Input: "abca" Output: True Explanation: You could delete the
 * character 'c'.
 * 
 * Note: The string will only contain lowercase characters a-z. The maximum
 * length of the string is 50000.
 *
 */
public class _680_ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		char[] chars = s.toCharArray();
		while (left < right) {
			if (chars[left] != chars[right]) {
				return isPalindrome(chars, left, right - 1) || isPalindrome(chars, left + 1, right);
			} else {
				left++;
				right--;
			}
		}
		return true;
	}

	private boolean isPalindrome(char[] chars, int left, int right) {
		while (left < right) {
			if (chars[left] != chars[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
