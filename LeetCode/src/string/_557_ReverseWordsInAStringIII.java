package string;

/**
 * 
 * Problem: Given a string, you need to reverse the order of characters in each
 * word within a sentence while still preserving whitespace and initial word
 * order.
 * 
 * Example 1: Input: "Let's take LeetCode contest" Output:
 * "s'teL ekat edoCteeL tsetnoc" Note: In the string, each word is separated by
 * single space and there will not be any extra space in the string.
 *
 */
public class _557_ReverseWordsInAStringIII {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int len = s.length();
		char[] chars = s.toCharArray();
		int prev = 0;
		int cur = 0;
		while (cur < len) {
			if (chars[cur] == ' ') {
				reverse(chars, prev, cur - 1);
				prev = cur + 1;
			}
			if (cur == len - 1) {
				reverse(chars, prev, cur);
			}
			cur++;
		}
		return new String(chars);
	}

	private void reverse(char[] chars, int left, int right) {
		while (left < right) {
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
	}
}
