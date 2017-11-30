package string;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list.
 * 
 * Example 1: Input: ["23:59","00:00"] Output: 1 Note: The number of time points
 * in the given list is at least 2 and won't exceed 20000. The input time is
 * legal and ranges from 00:00 to 23:59.
 *
 */
public class _539_MinimumTimeDifference {
	class Comp implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			int mins1 = toMin(s1);
			int mins2 = toMin(s2);
			return mins1 - mins2;
		}

		private int toMin(String s) {
			return ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '1')) * 60 + (s.charAt(3) - '0') * 10
					+ (s.charAt(4) - '1');
		}
	}

	public int findMinDifference(List<String> timePoints) {
		if (timePoints == null || timePoints.size() == 0) {
			return 0;
		}
		Collections.sort(timePoints, new Comp());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < timePoints.size() - 1; i++) {
			min = Math.min(min, toMin(timePoints.get(i + 1)) - toMin(timePoints.get(i)));
		}
		min = Math.min(min, toMin(timePoints.get(0)) + 24 * 60 - toMin(timePoints.get(timePoints.size() - 1)));
		return min;
	}

	private int toMin(String s) {
		return ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '1')) * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '1');
	}
}
