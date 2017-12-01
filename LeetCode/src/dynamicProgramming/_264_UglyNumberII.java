package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed
 * 1690.
 * 
 * Solution:
 * 
 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
 * 
 * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
 * 
 * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
 *
 */
public class _264_UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] res = new int[n];
		res[0] = 1;
		int[] factor = { 2, 3, 5 };
		int[] factors = { 2, 3, 5 };
		int[] indexes = { 0, 0, 0 };
		for (int i = 1; i < n; i++) {
			int min = Math.min(factors[0], Math.min(factors[1], factors[2]));
			res[i] = min;
			for (int j = 0; j < 3; j++) {
				if (factors[j] == min) {
					factors[j] = res[++indexes[j]] * factor[j];
				}
			}
		}
		return res[n - 1];
	}
}
