package bitManipulation;

/**
 * 
 * Problem:
 * 
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 *
 * Solution:
 * 
 * Time Complexity: O(N)
 * 
 * Space Complexity: O(1)
 *
 */
public class _260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		// First pass
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// get the last bit 1, 17 -> 1; 16 -> 16
		diff &= ~(diff - 1);
		// Second pass, divide all the numbers into two groups. one
		int[] res = { 0, 0 };
		for (int num : nums) {
			if ((num & diff) == 0) {
				res[0] ^= num;
			} else {
				res[1] ^= num;
			}
		}
		return res;
	}
}