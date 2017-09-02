package math;

/**
 * 
 * Problem: Given an integer, write a function to determine if it is a power of
 * three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 *
 */
public class _326_PowerOfThree {
	// Method 1
	public boolean isPowerOfThree1(int n) {
		if (n <= 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}

	// Method 2
	public boolean isPowerOfThree2(int n) {
		// 1162261467 is 3^19, 3^20 is bigger than Integer.MAX_VALUE;
		return (n > 0 && 1162261467 % n == 0);
	}
}
