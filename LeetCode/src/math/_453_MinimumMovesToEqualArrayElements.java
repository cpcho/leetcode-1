package math;

/**
 * 
 * Problem: Given a non-empty integer array of size n, find the minimum number
 * of moves required to make all array elements equal, where a move is
 * incrementing n - 1 elements by 1.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 3
 * 
 * Explanation: Only three moves are needed (remember each move increments two
 * elements):
 * 
 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 * 
 * 
 * Solution: Assume there are m moves, equal number is x;
 * 1. sum + m * (len - 1) = x * len
 * 2. x = minNum + m
 * So m = sum - minNum * len
 */
public class _453_MinimumMovesToEqualArrayElements {
	public int minMoves(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int num : nums) {
			min = Math.min(min, num);
			sum += num;
		}
		return sum - min * nums.length;
	}
}
