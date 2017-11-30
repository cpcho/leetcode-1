package string;

/**
 * 
 * Problem:
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Solution: 1. reverse the whole array 2.reverse each word
 *
 */
public class _151_ReverseWordsInString {
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		for (int i = 0, j = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {
				reverse(s, j, i - 1);
				j = i + 1;
			}
		}
	}

	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
}
