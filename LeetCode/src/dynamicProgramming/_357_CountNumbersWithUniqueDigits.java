package dynamicProgramming;

/**
 * 
 * Problem: Given a non-negative integer n, count all numbers with unique
 * digits, x, where 0 ≤ x < 10n.
 * 
 * Example: Given n = 2, return 91. (The answer should be the total numbers in
 * the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *
 */
public class _357_CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		// n =1;
		int sum = 10;
		int rest = 9;
		int uniqueSofar = 9;
		while (n-- > 1 && rest > 0) {
			// 0000X; 000XX; 00XXX; 0XXXX;
			uniqueSofar = uniqueSofar * rest;
			sum += uniqueSofar;
			rest--;
		}
		return sum;
	}
}
