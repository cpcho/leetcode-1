package binarySearch;

/**
 * 
 * Problem:
 * 
 * You have a total of n coins that you want to form in a staircase shape, where
 * every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 * 
 */
public class _441_ArrangingCoins {
	public int arrangeCoins1(int n) {
		int left = 0;
		int right = n;
		int mid = 0;
		if (n == 1) {
			return 1;
		}
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (0.5 * mid * mid + 0.5 * mid <= n) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (0.5 * left * left + 0.5 * left <= n) {
			return left;
		} else {
			return right;
		}
	}

	public int arrageCoins2(int n) {
		return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
	}

}
