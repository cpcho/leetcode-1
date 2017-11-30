package string;

/**
 * 
 * Problem:
 * 
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
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
	public String countAndSay(int n) {
		StringBuilder cur = new StringBuilder("1");
		StringBuilder pre;
		int count = 0;
		char say;
		for (int i = 1; i < n; i++) {
			pre = cur;
			cur = new StringBuilder();
			count = 1;
			say = pre.charAt(0);
			int len = pre.length();
			for (int j = 1; j < len; j++) {
				if (pre.charAt(j) != say) {
					cur.append(count).append(say);
					count = 1;
					say = pre.charAt(j);
				} else {
					count++;
				}
			}
			cur.append(count).append(say);
		}
		return cur.toString();
	}
}
