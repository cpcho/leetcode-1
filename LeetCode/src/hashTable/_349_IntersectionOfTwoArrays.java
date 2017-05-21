package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Problem: Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]. Note: Each
 * element in the result must be unique. The result can be in any order.
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
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
}