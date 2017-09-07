package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given a binary array, find the maximum length of a contiguous
 * subarray with equal number of 0 and 1.
 * 
 * Example 1:
 * 
 * Input: [0,1]
 * 
 * Output: 2
 * 
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0
 * and 1.
 * 
 * Example 2:
 * 
 * Input: [0,1,0]
 * 
 * Output: 2
 * 
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1. Note: The length of the given binary array will not exceed
 * 50,000.
 *
 */
public class _525_ContiguousArray {

	public int findMaxLength1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1); // the subarray starts from the beginning
		int sum = 0;
		int max = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}

	public int findMaxLength2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1); // the subarray starts from the beginning
		int sum = 0;
		int max = 0;
		for (int i = 0; i < len; i++) {
			sum += (nums[i] == 0 ? -1 : 1);
			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}
}
