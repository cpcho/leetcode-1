package dynamicProgramming;

/**
 * 
 * Problem: Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class _213_HouseRobberII {
	/**
	 * Method 1
	 */
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int len = nums.length;
		int[] res = new int[len];
		// do not rob the first one
		res[0] = 0;
		res[1] = nums[1];
		for (int i = 2; i < len; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
		}
		int max = res[len - 1];
		// rob the first one
		res[0] = nums[0];
		res[1] = Math.max(res[0], nums[1]);
		for (int i = 2; i < len; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
		}
		return Math.max(res[len - 2], max);
	}

	/**
	 * Method 2
	 */
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int len = nums.length;
		int[] res = new int[2];
		// do not rob the first one
		res[0] = 0;
		res[1] = nums[1];
		for (int i = 2; i < len; i++) {
			res[i % 2] = Math.max(res[(i - 1) % 2], res[(i - 2) % 2] + nums[i]);
		}
		int max = res[(len - 1) % 2];
		// rob the first one
		res[0] = nums[0];
		res[1] = Math.max(res[0], nums[1]);
		for (int i = 2; i < len; i++) {
			res[i % 2] = Math.max(res[(i - 1) % 2], res[(i - 2) % 2] + nums[i]);
		}
		return Math.max(res[(len - 2) % 2], max);
	}
}
