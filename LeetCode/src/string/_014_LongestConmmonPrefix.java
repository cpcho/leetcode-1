package string;

/**
 * 
 * Problem:
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 *
 */
public class _014_LongestConmmonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (String str : strs) {
			min = Math.min(min, str.length());
		}
		while (index < min) {
			String first = strs[0];
			char cur = first.charAt(index);
			for (String str : strs) {
				if (str.charAt(index) != cur) {
					return first.substring(0, index);
				}
			}
			index++;
		}
		return strs[0].substring(0, index);
	}
}
