package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem:
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3. Note:
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 *
 */
public class _494_TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return helper(nums, 0, 0, S, new HashMap<>());
	}

	private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map) {
		String encodeString = index + "->" + sum;
		if (map.containsKey(encodeString)) {
			return map.get(encodeString);
		}
		if (index == nums.length) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		int curNum = nums[index];
		int add = helper(nums, index + 1, sum + curNum, S, map);
		int minus = helper(nums, index + 1, sum - curNum, S, map);
		map.put(encodeString, add + minus);
		return add + minus;
	}
}
