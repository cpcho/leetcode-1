package math;

/**
 * 
 * Problem:
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 *
 */
public class _009_PalindromeNumber {
	public boolean isPalindrome(int x) {
		// last digit should not be a 0. 10 - > (x = 1, reverse = 1)
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int reverse = 0;
		while (x > reverse) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		return x == reverse || x == reverse / 10;
	}
}
