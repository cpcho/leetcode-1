package math;

/**
 * 
 * Problem:
 * 
 * Implement pow(x, n).
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10 Output: 1024.00000 Example 2:
 * 
 * Input: 2.10000, 3 Output: 9.26100
 *
 */
public class _050_Pow {

	/**
	 * 
	 * Method 1: Nest myPow
	 */
	public double myPow1(double x, int n) {
		if (n < 0) {
			// 1.00000, -2147483648 stackoverflow
			return 1 / x * myPow1(1 / x, -(n + 1));
		}
		if (n == 0) {
			return 1;
		}
		if (n == 2) {
			return x * x;
		}
		if (n % 2 == 0) {
			return myPow1(myPow1(x, n / 2), 2);
		} else {
			return x * myPow1(myPow1(x, n / 2), 2);
		}
	}

	/**
	 * Method 2: Double x
	 */

	public double myPow2(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				n = -(n + 1);
				x = 1 / (x * x);
			} else {
				n = -n;
				x = 1 / x;
			}
		}
		return n % 2 == 0 ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);
	}

	/**
	 * 
	 * Method 3: Iteration
	 */
	public double myPow3(double x, int n) {
		double res = 1;
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				n = -(n + 1);
				x = 1 / (x * x);
			} else {
				n = -n;
				x = 1 / x;
			}
		}
		while (n > 0) {
			if ((n & 1) == 1) {
				res *= x;
			}
			x *= x;
			n >>= 1;
		}
		return res;
	}

}
