package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 *
 */
public class _229_MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int num1 = nums[0];
		int num2 = nums[0];
		int count1 = 0;
		int count2 = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == num1) {
				count1++;
			} else if (nums[i] == num2) {
				count2++;
			} else if (count1 == 0) {
				num1 = nums[i];
				count1++;
			} else if (count2 == 0) {
				num2 = nums[i];
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		// check count1 and count2
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == num1) {
				count1++;
			} else if (num == num2) { // else is needed. repeation
				count2++;
			}
		}
		if (count1 > len / 3) {
			res.add(num1);
		}
		if (count2 > len / 3) {
			res.add(num2);
		}
		return res;
	}
}
