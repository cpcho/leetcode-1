package bitManipulation;

/**
 * 
 * Problem:
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 *
 */
public class _371_SumOfTwoIntegers {
	public int getSum(int a, int b) {
		int res = a;
		int carry = b;
		if (carry == 0) {
			return res;
		}
		res = a ^ b; // without carry;
		carry = (a & b) << 1;
		return getSum(res, carry);
	}
}
