package math;

/**
 * 
 * Problem: Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5,
 * 6, 7, 8, 9, 10, 11, ...
 * 
 * Note: n is positive and will fit within the range of a 32-bit signed integer
 * (n < 231).
 * 
 * Example 1:
 * 
 * Input: 3
 * 
 * Output: 3 Example 2:
 * 
 * Input: 11
 * 
 * Output: 0
 * 
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ... is a 0, which is part of the number 10.
 *
 */
public class _400_NthDigit {
	public int findNthDigit(int n) {
		int res;
		long digitsRange = 9;
		int digits = 2;
		int j = 10;
		while (n > digitsRange) {
			n -= digitsRange;
			digitsRange = (long) 9 * j * digits++;
			j *= 10;
		}
		if (n % (digits - 1) == 0) {
			res = n / (digits - 1) + j / 10 - 1;
		} else {
			res = n / (digits - 1) + j / 10;
		}
		int k = (n + digits - 2) % (digits - 1);
		String s = Integer.toString(res);
		res = Character.getNumericValue(s.charAt(k));
		return res;
	}
}
