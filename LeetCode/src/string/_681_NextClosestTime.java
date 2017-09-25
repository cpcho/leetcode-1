package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * Problem:
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * 
 * Input: "19:34" Output: "19:39" Explanation: The next closest time choosing
 * from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It is not
 * 19:33, because this occurs 23 hours and 59 minutes later. Example 2:
 * 
 * Input: "23:59" Output: "22:22" Explanation: The next closest time choosing
 * from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is
 * next day's time since it is smaller than the input time numerically.
 *
 */
public class _681_NextClosestTime {
	public String nextClosestTime(String time) {
		Set<Integer> digits = new HashSet<>();
		List<Integer> validHours = new LinkedList<>();
		List<Integer> validMinutes = new LinkedList<>();
		for (char c : time.toCharArray()) { // get unique numbers
			if (c == ':') {
				continue;
			}
			digits.add(c - '0');
		}
		int[] arrayDigits = new int[digits.size()]; // set to array
		int index = 0;
		for (int digit : digits) {
			arrayDigits[index++] = digit;
		}
		Arrays.sort(arrayDigits); // make sure get next time increasingly.
		for (int i = 0; i < arrayDigits.length; i++) { //
			for (int j = 0; j < arrayDigits.length; j++) {
				int cur = arrayDigits[i] * 10 + arrayDigits[j];
				if (cur < 24) {
					validHours.add(cur);
				}
				if (cur < 60) {
					validMinutes.add(cur);
				}
			}
		}
		int curMinutes = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
		for (int num : validHours) {
			for (int num2 : validMinutes) {
				if (num * 60 + num2 > curMinutes) {
					return intToString(new int[] { num, num2 });
				}
			}
		}
		return intToString(new int[] { validHours.get(0), validMinutes.get(0) });
	}

	private static String intToString(int[] num) {
		String res = "";
		if (num[0] < 10) {
			res += "0";
		}
		res += num[0];
		res += ":";
		if (num[1] < 10) {
			res += "0";
		}
		res += num[1];
		return res;
	}
}
