package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class _198_HouseRobber {
	/**
	 * 
	 * Method 1
	 * 
	 * Space Complexity: O(N)
	 */
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] res = new int[len + 1];
		res[0] = 0;
		res[1] = nums[0];
		for (int i = 2; i <= len; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1]);
		}
		return res[len];
	}

	/**
	 * Method 2
	 * 
	 * There only three useful states % 2, 3, 4.....
	 */
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] res = new int[2];
		res[0] = 0;
		res[1] = nums[0];
		for (int i = 2; i <= len; i++) {
			res[i % 2] = Math.max(res[(i - 1) % 2], res[(i - 2) % 2] + nums[i - 1]);
		}
		return res[len % 2];
	}

	/**
	 * 
	 * Method 3
	 */
	public int rob3(int[] nums) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + nums[i], b);
			} else {
				b = Math.max(a, b + nums[i]);
			}
		}
		return Math.max(a, b);
	}
}
