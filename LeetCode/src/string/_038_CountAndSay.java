package string;

/**
 * 
 * Problem: The count-and-say sequence is the sequence of integers with the
 * first five terms as following:
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1 Output: "1" Example 2:
 * 
 * Input: 4 Output: "1211"
 *
 */
public class _038_CountAndSay {
	public int lengthOfLastWord(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		int len = s.length() - 1;
		int end = len;
		int count = 0;
		while (end >= 0) {
			if (s.charAt(end) != ' ') {
				break;
			}
			end--;
		}
		if (end == -1) { // all chars are space
			return 0;
		}
		while (end >= 0) {
			if (s.charAt(end) != ' ') {
				count++;
			} else {
				return count;
			}
			end--;
		}
		return count;
	}
}
