package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Problem: Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 *
 */
public class _349_IntersectionOfTwoArrays {
	/**
	 * Method 1
	 * 
	 * Time Complexity: O(N + M)
	 */
	public int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}
		for (int i : nums2) {
			if (set1.contains(i))
				set2.add(i);
		}
		int res[] = new int[set2.size()];
		int iter = 0;
		for (Integer s : set2) {
			res[iter++] = s;
		}
		return res;
	}

	/**
	 * Method 2:
	 * 
	 * Time Complexity: O(NlogN + MlogM)
	 * 
	 */
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			res[k++] = num;
		}
		return res;
	}
}
