package binarySearch;

/**
 * 
 * @author chengfeili 
 * Jun 17, 2017 10:55:00 AM
 * 
 *         Problem: Implement int sqrt(int x).
 * 
 *         Compute and return the square root of x.
 *
 *         Solution:
 * 
 *         Time Complexity:
 * 
 *         Space Complexity:
 *
 */
public class _069_Sqrt {
	public int mySqrt(int x) {
		long left = 1;
		long right = x;
		long mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right * right <= x ? (int) right : (int) left;
	}
}
