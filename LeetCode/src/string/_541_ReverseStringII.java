package string;

/**
 * 
 * Problem: Given a string and an integer k, you need to reverse the first k
 * characters for every 2k characters counting from the start of the string. If
 * there are less than k characters left, reverse all of them. If there are less
 * than 2k but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original. Example: Input: s = "abcdefg", k =
 * 2 Output: "bacdfeg" Restrictions: The string consists of lower English
 * letters only. Length of the given string and k will in the range [1, 10000]
 *
 */
public class _541_ReverseStringII {
	public String reverseStr(String s, int k) {
		int left = 0;
		int right = k - 1;
		char[] chars = s.toCharArray();
		int len = s.length();
		int last = len % (2 * k);
		while (right < len - last) {
			reverse(chars, left, right);
			left = right + k + 1;
			right = right + k + k;

		}
		if (last >= k) {
			reverse(chars, left, right);
		} else {
			reverse(chars, left, len - 1);
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
