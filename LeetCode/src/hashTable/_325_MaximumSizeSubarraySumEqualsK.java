package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given an array nums and a target value k, find the maximum length of
 * a subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit
 * signed integer range.
 * 
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the
 * subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the
 * subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up: Can you do it in O(n) time?
 *
 */
public class _325_MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null) {
			return 0;
		}
		int res = 0;
		int sum = 0;
		// key is the sum from 0 to i, value is the index
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (sum == k) { // from o to i
				res = i + 1;
			} else if (map.containsKey(sum - k)) {
				res = Math.max(res, i - map.get(sum - k));
			}
		}
		return res;
	}
}
