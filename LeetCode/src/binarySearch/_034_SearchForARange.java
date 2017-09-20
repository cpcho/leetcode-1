package binarySearch;

/**
 * 
 * Problem:
 * 
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 */
public class _034_SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int left = firstGreatEqual(nums, target);
		if (left >= nums.length || nums[left] != target) {
			return new int[] { -1, -1 };
		}
		int right = firstGreatEqual(nums, target + 1);
		return new int[] { left, right - 1 };
	}

	private static int firstGreatEqual(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else
				right = mid;
		}
		return left;
	}
}
