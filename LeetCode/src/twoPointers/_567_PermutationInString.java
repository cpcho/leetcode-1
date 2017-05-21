package twoPointers;

/**
 * 
 * Problem: Given two strings s1 and s2, write a function to return true if s2
 * contains the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * Example 1: Input:s1 = "ab" s2 = "eidbaooo" Output:True Explanation: s2
 * contains one permutation of s1 ("ba"). Example 2: Input:s1= "ab" s2 =
 * "eidboaoo" Output: False Note: The input strings only contain lower case
 * letters. The length of both given strings is in range [1, 10,000]. Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _567_PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() > s2.length()) {
			return false;
		}
		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			if (isPerm(s1, s2.substring(i, i + s1.length()))) {
				return true;
			}
		}
		return false;
	}

	private boolean isPerm(String s1, String s2) {
		int[] count = new int[26];
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			count[ch1[i] - 'a']++;
		}
		for (int i = 0; i < ch1.length; i++) {
			if (count[ch2[i] - 'a']-- <= 0) {
				return false;
			}
		}
		return true;
	}
}