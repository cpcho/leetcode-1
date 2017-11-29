package math;

/**
 * 
 * Problem:
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 */
public class _258_AddDigits {
	public int addDigits1(int num) {
		if (num <= 0) {
			return 0;
		}
		return num % 9;
	}

	/**
	 * 
	 * input: 0 1 2 3 4 5 6 7 8 9 10 11 12 13
	 * 
	 * output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ....
	 * 
	 */
	public int addDigits2(int num) {
		return 1 + ((num - 1) % 9);
	}
}
