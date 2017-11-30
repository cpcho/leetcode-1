package twoPointers;

/**
 * 
 * Problem:
 * 
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1: Given s = "hello", return "holle".
 * 
 * Example 2: Given s = "leetcode", return "leotcede".
 * 
 * Note: The vowels does not include the letter "y".
 * 
 */
public class _345_ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int left = 0;
		int right = s.length() - 1;
		char[] ch = s.toCharArray();
		while (left < right) {
			if (!isVowel(ch[left])) {
				left++;
			} else if (!isVowel(ch[right])) {
				right--;
			} else {
				char tmp = ch[left];
				ch[left] = ch[right];
				ch[right] = tmp;
				left++;
				right--;
			}
		}
		return new String(ch);
	}

	private boolean isVowel(char c) {
		return "aeiouAEIOU".contains(c + "");
	}
}
