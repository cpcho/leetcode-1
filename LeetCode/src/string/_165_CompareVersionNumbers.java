package string;

/**
 * 
 * Problem: Compare two version numbers version1 and version2. If version1 >
 * version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * 
 * 1.0.0 == 1
 * 
 * 1.1 > 1
 */
public class _165_CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int len1 = s1.length;
		int len2 = s2.length;
		while (len1 > 0 && Integer.parseInt(s1[len1 - 1]) == 0) {
			len1--;
		}
		while (len2 > 0 && Integer.parseInt(s2[len2 - 1]) == 0) {
			len2--;
		}
		int index = 0;
		while (index < len1 && index < len2) {
			int num1 = Integer.parseInt(s1[index]);
			int num2 = Integer.parseInt(s2[index]);
			if (num1 > num2) {
				return 1;
			}
			if (num1 < num2) {
				return -1;
			}
			if (num1 == num2) {
				index++;
			}
		}

		return len1 > len2 ? 1 : len1 < len2 ? -1 : 0;
	}
}
