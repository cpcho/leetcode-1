package bitManipulation;

/**
 * 
 * Problem:
 * 
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The
 * two words can be "ab", "cd".
 * 
 * Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
 *
 * Solution: a-z only 26 bits. we can use 32 bit integer to store the exist of
 * each char in the string
 * 
 * Time Complexity: O(N2)
 * 
 * Space Complexity:O(N)
 *
 */
public class _318_MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		int len = words.length;
		int res = 0;
		int[] bits = new int[len];
		for (int i = 0; i < len; i++) {
			char[] tmp = words[i].toCharArray();
			for (int j = 0; j < tmp.length; j++) {
				bits[i] |= 1 << (tmp[j] - 'a');
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((bits[i] & bits[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;
	}
}
