package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem: Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2]. Note:
 * Each element in the result should appear as many times as it shows in both
 * arrays. The result can be in any order. Follow up: What if the given array is
 * already sorted? How would you optimize your algorithm? What if nums1's size
 * is small compared to nums2's size? Which algorithm is better? What if
 * elements of nums2 are stored on disk, and the memory is limited such that you
 * cannot load all elements into the memory at once?
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _350_IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> hash = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		// key is the unique element of nums1,
		// value is the number of each elements
		for (int num : nums1) {
			if (!hash.containsKey(num))
				hash.put(num, 1);
			else
				hash.put(num, hash.get(num) + 1);
		}
		for (int num : nums2) {
			if (hash.containsKey(num) && hash.get(num) > 0) {
				list.add(num);
				// decrease the value of the key found
				hash.put(num, hash.get(num) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}