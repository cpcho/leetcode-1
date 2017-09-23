package binarySearch;

/**
 * 
 * Problem:
 * 
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Returns: True Example 2:
 * 
 * Input: 14 Returns: False
 *
 */
public class _367_ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int left = 0, right = num, mid;
		if (num == 0 || num == 1) {
			return true;
		}
		int d = (int) Math.sqrt(Integer.MAX_VALUE);
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (mid * mid == num) {
				return true;
			}
			if (mid <= d && mid * mid < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
