package dynamicProgramming;

/**
 * 
 * Problem: A message containing letters from A-Z is being encoded to numbers
 * using the following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 *
 */
public class _091_DecodeWays {
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		int[] res = new int[len + 1];
		// from end to beginning
		res[len] = 1;
		res[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			} else {
				res[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? res[i + 1] + res[i + 2] : res[i + 1];
			}
		}
		return res[0];
	}
}
