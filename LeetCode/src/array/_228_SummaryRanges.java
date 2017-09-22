package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1: Input: [0,1,2,4,5,7] Output: ["0->2","4->5","7"]
 * 
 * Example 2: Input: [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"]
 *
 */
public class _228_SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int left, right;
		int index = 0;
		while (index < nums.length) {
			left = index;
			while (index < nums.length - 1 && nums[index] + 1 == nums[index + 1]) {
				index++;
			}
			right = index;
			if (right > left) {
				res.add(nums[left] + "->" + nums[right]);
			} else {
				res.add(nums[left] + "");
			}
			index++;
		}
		return res;
	}
}
