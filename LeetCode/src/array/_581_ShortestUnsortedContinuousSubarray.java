package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * Problem:
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15]
 * 
 * Output: 5 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order
 * to make the whole array sorted in ascending order.
 * 
 * Note: Then length of the input array is in range [1, 10,000]. The input array
 * may contain duplicates, so ascending order here means <=.
 * 
 */
public class _581_ShortestUnsortedContinuousSubarray {

	/**
	 * Method 1: Sort
	 * 
	 * Time Complexity: O(NlogN)
	 * 
	 * Space Complexity: O(N)
	 */
	public int findUnsortedSubarray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int[] nums2 = nums.clone();
		Arrays.sort(nums2);
		int left = nums.length;
		int right = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums2[i]) {
				left = Math.min(left, i);
				right = Math.max(right, i);
			}
		}
		return right > left ? right - left + 1 : 0;
	}

	/**
	 * Method 2: Stack
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(N)
	 */
	public int findUnsortedSubarray2(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int len = nums.length;
		int left = len;
		int right = 0;
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				left = Math.min(left, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();
		for (int i = len - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				right = Math.max(right, stack.pop());
			}
			stack.push(i);
		}
		return right > left ? right - left + 1 : 0;
	}

	/**
	 * Method 3:
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(1)
	 */
	public int findUnsortedSubarray3(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				min = Math.min(min, nums[i + 1]);
			}
		}
		for (int i = len - 1; i > 0; i--) {
			if (nums[i] < nums[i - 1]) {
				max = Math.max(max, nums[i - 1]);
			}
		}
		int i = 0;
		int j = len - 1;
		for (; i < len; i++) {
			if (min < nums[i]) {
				break;
			}
		}
		for (; j >= 0; j--) {
			if (max > nums[j]) {
				break;
			}
		}
		return j > i ? j - i + 1 : 0;
	}
}
