package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Problem: Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * Solution:
 * 
 * Time Complexity: O(NlogN), where N is the size of intervals for sorting.
 * 
 * Space Complexity: O(1)
 *
 */

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class _056_MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
		Comparator<Interval> comp = new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				if (a.start != b.start) {
					return a.start - b.start;
				} else {
					return a.end - b.end;
				}
			}
		};
		Collections.sort(intervals, comp);
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval inter : intervals) {
			if (inter.start <= end) {
				end = Math.max(end, inter.end);
			} else {
				res.add(new Interval(start, end));
				start = inter.start;
				end = inter.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}
}
