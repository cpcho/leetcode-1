package array;

/**
 * 
 * Problem:
 * 
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 *
 */
public class _238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int len = nums.length;
		int[] res = new int[len];
		int tmp = 1;
		// get the product of all the elements on the left of i
		for (int i = 0; i < len; i++) {
			res[i] = tmp;
			tmp *= nums[i];
		}
		tmp = 1;
		// get the product of all the elements on the right of i
		for (int i = len - 1; i >= 0; i--) {
			res[i] *= tmp;
			tmp *= nums[i];
		}
		return res;
	}
}
