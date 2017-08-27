package array;

/**
 * 
 * Problem: Given an unsorted integer array, find the first missing positive
 * integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class _041_FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		if (nums == null) {
			return -1;
		}
		int len = nums.length;
		// put the number in the right place.
		for (int i = 0; i < len; i++) {
			// while, set the previous elements
			while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
				swap(nums, i);
			}
		}
		for (int i = 0; i < len; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return len + 1;
	}

	private static void swap(int[] nums, int i) {
		int tmp = nums[i];
		nums[i] = nums[nums[i] - 1];
		nums[tmp - 1] = tmp;
	}
}
