package bitManipulation;

/**
 * 
 * Problem: Given an integer (signed 32 bits), write a function to check whether
 * it is a power of 4.
 * 
 * Example: Given num = 16, return true. Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 *
 */
public class _342_PowerOfFour {
	public boolean isPowerOfFour(int num) {
		if (num == 1) {
			return true;
		}
		if (Integer.bitCount(num) == 1) {
			if ((Math.log(Integer.highestOneBit(num)) / Math.log(2)) % 2 == 0 && num >= 4) {
				return true;
			}
		}
		return false;
	}
}
