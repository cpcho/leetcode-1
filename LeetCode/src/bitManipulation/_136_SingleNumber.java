package bitManipulation;

/**
 * 
 * Problem:
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 *
 */
public class _136_SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums == null) {
			return -1;
		}
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}
}
