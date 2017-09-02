package math;

/**
 * 
 * Problem:
 *
 * Solution:
 * 
 * Time Complexity:
 * 
 * Space Complexity:
 *
 */
public class _396_RotateFunction {

	/**
	 * Method 1: O(N^2)
	 * Time limit exceeded
	 */
	public int maxRotateFunction(int[] A) {
		int res = Integer.MIN_VALUE;
		if (A == null || A.length == 0) {
			return 0;
		}
		for (int i = 0; i < A.length; i++) {
			int cur = 0;
			for (int j = 0; j < A.length; j++) {
				cur += ((i + j) % A.length) * A[j];
			}
			res = Math.max(res, cur);
		}
		return res;
	}

	/**
	 * Method 2: O(N)
	 */
	public int maxRotateFunction2(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int len = A.length;
		int sumOfA = 0;
		int f = 0;
		for (int i = 0; i < len; i++) {
			sumOfA += A[i];
			f += i * A[i];
		}
		int res = f;
		for (int i = 1; i < len; i++) {
			f = f - sumOfA + A[i - 1] * len;
			res = Math.max(res, f);
		}
		return res;
	}
}
