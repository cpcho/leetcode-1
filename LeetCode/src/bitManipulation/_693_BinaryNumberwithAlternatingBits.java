package bitManipulation;

/**
 * 
 * Problem:
 *
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 * 
 * Example 1: Input: 5 Output: True Explanation: The binary representation of 5
 * is: 101
 * 
 * Example 2: Input: 7 Output: False Explanation: The binary representation of 7
 * is: 111.
 * 
 * Example 3: Input: 11 Output: False Explanation: The binary representation of
 * 11 is: 1011.
 * 
 * Example 4: Input: 10 Output: True Explanation: The binary representation of
 * 10 is: 1010.
 */
public class _693_BinaryNumberwithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		long cur = 1;
		long sum = 1;
		while (cur < Integer.MAX_VALUE && sum < Integer.MAX_VALUE && sum < n) {
			cur *= 4;
			sum += cur;
		}
		long cur2 = 2;
		long sum2 = 2;
		while (cur2 <= Integer.MAX_VALUE && sum2 < Integer.MAX_VALUE && sum2 < n) {
			cur2 *= 4;
			sum2 += cur2;
		}
		return sum == n || sum2 == n;
	}
}
