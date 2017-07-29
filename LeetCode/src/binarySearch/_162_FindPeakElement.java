package binarySearch;

/**
 * 
 * Problem: A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 *
 */
public class _162_FindPeakElement {
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid - 1]) {
				right = mid;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid;
			} else {
				// nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]
				right = mid; // or left = mid;
			}
		}
		if (nums[left] < nums[right]) {
			return right;
		} else {
			return left;
		}
	}
}
