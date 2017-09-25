package binarySearch;

/**
 * 
 * Problem:
 * 
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array
 * sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 *
 */
public class _154_FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				// go right
				left = mid;
			} else if (nums[mid] < nums[right]) {
				// go left
				right = mid;
			} else {
				// nums[mid] = nums[right]
				right--;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
