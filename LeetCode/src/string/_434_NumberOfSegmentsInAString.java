package string;

/**
 * 
 * Problem:
 * 
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * 
 * Output: 5
 *
 */
public class _434_NumberOfSegmentsInAString {
	public int countSegments(String s) {
		int count = 0;
		if (s == null || s.length() == 0) {
			return count;
		}
		int index = 0;
		while (index < s.length()) {
			if (s.charAt(index) != ' ') {
				count++;
				index++;
				while (index < s.length() && s.charAt(index) != ' ') {
					index++;
				}
			} else {
				index++;
			}
		}
		return count;
	}
}
