package twoPointers;

/**
 * 
 * Problem: Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _028_ImplementstrStr {
	public int strStr(String source, String target) {
		if (target == "") {
			return 0;
		}
		if (source == null || target == null || source == "" || target.length() > source.length()) {
			return -1;
		}
		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			int j = 0;
			for (j = 0; j < target.length(); j++) {
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
			}
			if (target.length() == j) {
				return i;
			}
		}
		return -1;
	}
}