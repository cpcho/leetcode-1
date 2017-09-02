package math;

/**
 * 
 * Problem: Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class _172_FactorialTrailingZeroes {
	// Method 1
	public int trailingZeroes1(int n) {
		if (n < 0) {
			n = -n;
		}
		int res = 0;
		for (long i = 5; i <= n; i *= 5) { // i should be in long, overflow
			res += n / i;
		}
		return res;
	}

	// Method 2
	public int trailingZeroes2(int n) {
		if (n < 0) {
			n = -n;
		}
		int res = 0;
		while (n > 0) {
			res = res + n / 5;
			n = n / 5;
		}
		return res;
	}
}
