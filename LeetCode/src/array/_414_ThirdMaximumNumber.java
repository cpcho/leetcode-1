package array;

/**
 * 
 * Problem:
 * 
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1: Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned
 * instead.
 * 
 * Example 3: Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number. Both numbers with value 2 are both considered as second
 * maximum.
 *
 */
public class _414_ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		int min = Integer.MIN_VALUE;
		int firstMax = min, secoundMax = min, thirdMax = min;
		int count = 0;
		for (int i : nums) {
			if (i == Integer.MIN_VALUE) {
				count++;
			}
			if ((firstMax == i || secoundMax == i)) {
				continue;
			} else if (i > firstMax) {
				thirdMax = secoundMax;
				secoundMax = firstMax;
				firstMax = i;
			} else if (i > secoundMax) {
				thirdMax = secoundMax;
				secoundMax = i;
			} else if (i >= thirdMax) {
				thirdMax = i;
			}
		}
		if ((thirdMax == Integer.MIN_VALUE) && count == 0)
			return firstMax;
		else if (firstMax > secoundMax && secoundMax > thirdMax) {
			return thirdMax;
		} else {
			return firstMax;
		}
	}
}
