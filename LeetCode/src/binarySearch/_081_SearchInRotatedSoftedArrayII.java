package binarySearch;

/**
 * 
 * Problem:
 * 
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array
 * sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 */
public class _081_SearchInRotatedSoftedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] < nums[right]) { // right side is in ascending
													// order
				if (target > nums[mid] && target <= nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			} else if (nums[mid] > nums[right]) { // left side is in ascending
													// order
				if (target < nums[mid] && target >= nums[left]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				right--; // important 1 1 3 1
			}
		}
		return nums[left] == target || nums[right] == target;
	}
}
