package math;

import java.util.Arrays;

/**
 * 
 * Problem: Given a non-empty integer array, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing a
 * selected element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: Only two moves are needed (remember each move increments or
 * decrements one element):
 * 
 * [1,2,3] => [2,2,3] => [2,2,2]
 */
public class _462_MinimumMovesToEqualArrayElementII {
	public int minMoves2(int[] nums) {
		if (nums == null) {
			return 0;
		}
		Arrays.sort(nums);
		int res = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			res += nums[right] - nums[left];
			left++;
			right--;
		}
		return res;
	}
}
