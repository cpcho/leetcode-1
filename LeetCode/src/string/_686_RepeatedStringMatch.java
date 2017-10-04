package string;

/**
 * 
 * Problem:
 *
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 *
 * 
 */
public class _686_RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		int res = 1;
		StringBuilder sb = new StringBuilder(A);
		while (sb.length() < B.length()) {
			sb.append(A);
			res++;
		}
		if (sb.indexOf(B) != -1) {
			return res;
		}
		if (sb.append(A).indexOf(B) != -1) {
			return res + 1;
		}
		return -1;
	}
}
