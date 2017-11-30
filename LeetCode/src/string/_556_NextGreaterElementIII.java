package string;

/**
 * 
 * Problem:
 * 
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1: Input: 12 Output: 21
 * 
 * Example 2: Input: 21 Output: -1
 *
 */
public class _556_NextGreaterElementIII {
	public int nextGreaterElement(int num) {
		String n = Integer.toString(num);
		for (int i = n.length() - 2; i >= 0; i--) {
			if (n.charAt(i) >= n.charAt(i + 1)) {
				continue;
			}
			for (int j = n.length() - 1; j > i; j--) {
				if (n.charAt(j) <= n.charAt(i))
					continue;
				try {
					return Integer
							.parseInt(
									n.substring(0, i) + n.charAt(j)
											+ new StringBuilder(
													n.substring(i + 1, j) + n.charAt(i) + n.substring(j + 1)).reverse()
															.toString());
				} catch (Exception e) {
					return -1;
				}
			}
		}
		return -1;
	}
}
