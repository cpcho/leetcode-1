package queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Problem: Given an array nums, there is a sliding window of size k which is
 * moving from the very left of the array to the very right. You can only see
 * the k numbers in the window. Each time the sliding window moves right by one
 * position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * [3,3,5,5,6,7].
 * 
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * Follow up: Could you solve it in linear time?
 *
 */
public class _239_SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k > nums.length || k <= 0) {
			return new int[0];
		}
		int len = nums.length;
		int[] res = new int[len - k + 1];
		int index = 0;
		// store the index( 0, len - 1)
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < len; i++) {
			// remove the out range element
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			// remove useless element
			while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offer(i);
			if (i >= k - 1) {
				res[index++] = nums[deque.peek()];
			}
		}
		return res;
	}
}
