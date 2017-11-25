package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 *
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self
 * dividing number, including the bounds if possible.
 * 
 * Example 1: Input: left = 1, right = 22 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9,
 * 11, 12, 15, 22] Note:
 * 
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 * 
 * 
 */
public class _728_SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (selfDividing(i)) {
				res.add(i);
			}
		}
		return res;
	}

	private boolean selfDividing(int num) {
		int n = num;
		int d = 0;
		while (n > 0) {
			d = n % 10;
			n /= 10;
			if (d == 0 || (num % d) > 0) {
				return false;
			}
		}
		return true;
	}
}
