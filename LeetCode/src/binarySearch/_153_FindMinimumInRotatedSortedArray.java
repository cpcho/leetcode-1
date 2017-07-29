package binarySearch;

/**
 * 
 * Problem: Suppose an array sorted in ascending order is rotated at some pivot
 * unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 *
 */
public class _153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
