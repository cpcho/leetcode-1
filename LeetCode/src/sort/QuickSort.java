package sort;

import java.util.Random;

/**
 * 
 * Problem:
 * 
 * Quick Sort
 * 
 * Time Complexity: O(NlogN); O(N^2) for worst case
 * 
 * Space Complexity: O(logN) for the recursion stack
 */
public class QuickSort {

	public Random rand;

	public void sort(int[] nums) {
		rand = new Random();
		quickSort(nums, 0, nums.length - 1);
	}

	public void quickSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		// partition
		int index = rand.nextInt(end - start + 1) + start;
		int pivot = nums[index];
		int left = start;
		int right = end;
		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}
			while (left <= right && nums[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}
		quickSort(nums, start, right);
		quickSort(nums, left, end);
	}
}
