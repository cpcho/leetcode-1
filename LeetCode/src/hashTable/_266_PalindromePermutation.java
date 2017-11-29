package hashTable;

/**
 * 
 * Problem:
 * 
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 *
 */
public class _266_PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null) {
			return false;
		}
		int[] map = new int[256];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
		}
		boolean odd = false;
		for (int num : map) {
			if (num % 2 == 1) {
				if (odd) {
					return false;
				}
				odd = true;
			}
		}
		return true;
	}
}
