package twoPointers;

/**
 * 
 * Problem: Given two sorted integer arrays nums1 and nums2, merge nums2 into
 * nums1 as one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */

public class _088_MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len1 = m - 1;
		int len2 = n - 1;
		int IndexFromBack = m + n - 1;
		// compare until one of them is empty
		while (len1 >= 0 && len2 >= 0) {
			nums1[IndexFromBack--] = (nums1[len1] > nums2[len2]) ? nums1[len1--] : nums2[len2--];
		}

		// when nums2 is empty, done.
		// when nums1 is empty
		while (len2 >= 0) {
			nums1[IndexFromBack--] = nums2[len2--];
		}
	}
}