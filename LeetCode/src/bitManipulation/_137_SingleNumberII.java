package bitManipulation;

/**
 * 
 * Problem: Given an array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * Solution: A number appears 3 times at most, so we need 2 bits to store that.
 * 00, 01, 10. Let 'ones' represents the first bit, 'twos' represents the second
 * bit. For 'ones', we can get 'ones = ones ^ A[i]; if (twos == 1) then ones =
 * 0', that can be transformed to 'ones = (ones ^ A[i]) & ~twos'.
 */
public class _137_SingleNumberII {
	public int singleNumber(int[] nums) {
		int one = 0;
		int two = 0;
		for (int i = 0; i < nums.length; i++) {
			one = (one ^ nums[i]) & ~two;
			two = (two ^ nums[i]) & ~one;
		}
		return one;
	}
}
