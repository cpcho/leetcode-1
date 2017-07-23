package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Problem: Given a list of non negative integers, arrange them such that they
 * form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 *
 * Time Complexity: O(NlogN)
 * 
 * Space Complexity: O(1)
 *
 */
public class _179_LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] s = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			s[i] = String.valueOf(nums[i]);
		}
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String a = s1 + s2;
				String b = s2 + s1;
				return b.compareTo(a);
			}
		};
		Arrays.sort(s, comp);
		if (s[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String iter : s) {
			sb.append(iter);
		}
		return sb.toString();
	}
}
