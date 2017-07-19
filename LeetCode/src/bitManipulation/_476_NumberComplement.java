package bitManipulation;

/**
 * 
 * Problem:Given a positive integer, output its complement number. The
 * complement strategy is to flip the bits of its binary representation.
 * 
 * Note: The given integer is guaranteed to fit within the range of a 32-bit
 * signed integer. You could assume no leading zero bit in the integer’s binary
 * representation.
 * 
 * Example 1: Input: 5 Output: 2 Explanation: The binary representation of 5 is
 * 101 (no leading zero bits), and its complement is 010. So you need to output
 * 2.
 * 
 * Example 2: Input: 1 Output: 0 Explanation: The binary representation of 1 is
 * 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 */
public class _476_NumberComplement {
	public int findComplement1(int num) {
		return num ^ ((Integer.highestOneBit(num) << 1) - 1);
	}

	/**
	 * 
	 * 101 + 10 = 111
	 */
	public int findComplement2(int num) {
		int i = 0;
		int j = 0;
		while (i < num) {
			i += 1 << j;
			j++;
		}
		return i - num;
	}
}
