package string;

/**
 * 
 * Problem:
 * 
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 *
 */
public class _161_OneEditDistance {
	/**
	 * Method 1
	 */
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) {
			return false;
		}
		int len1 = s.length();
		int len2 = t.length();
		if (len1 == len2) {
			return replace(s, t);
		}
		if (len1 + 1 == len2) {
			return insert(s, t);
		}
		if (len2 + 1 == len1) {
			return insert(t, s);
		}
		return false;
	}

	public boolean replace(String s, String t) {
		boolean oneChar = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (oneChar) {
					return false;
				}
				oneChar = true;
			}
		}
		return true;
	}

	// s is shorter
	public boolean insert(String s, String t) {
		int len1 = 0;
		int len2 = 0;
		while (len1 < s.length() && len2 < t.length()) {
			if (s.charAt(len1) != t.charAt(len2)) {
				if (len1 != len2) {
					return false;
				}
				len2++;
			} else {
				len1++;
				len2++;
			}
		}
		return true;
	}

	/**
	 * Method2: Handle replace and insert in the same method;
	 */
	public boolean isOneEditDistance2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() - s2.length() == 0) {
			return false;
		}
		String str1 = s1.length() < s2.length() ? s1 : s2;
		String str2 = s1.length() < s2.length() ? s2 : s1;
		assert (str1.length() <= str2.length());
		int index1 = 0;
		int index2 = 0;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		boolean foundDiff = false;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (chars1[index1] != chars2[index2]) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
				if (chars1.length == chars2.length) {
					index1++;
				}
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}
}
