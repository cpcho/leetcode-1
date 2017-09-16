package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Problem: Given an integer array, your task is to find all the different
 * possible increasing subsequences of the given array, and the length of an
 * increasing subsequence should be at least 2 .
 * 
 * Example: Input: [4, 6, 7, 7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7,
 * 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]] Note: The length of the given array
 * will not exceed 15. The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be
 * considered as a special case of increasing sequence. Given an integer array,
 * your task is to find all the different possible increasing subsequences of
 * the given array, and the length of an increasing subsequence should be at
 * least 2 .
 * 
 * Example: Input: [4, 6, 7, 7]
 * 
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * [4,7,7]]
 * 
 * Note: The length of the given array will not exceed 15. The range of integer
 * in the given array is [-100,100]. The given array may contain duplicates, and
 * two equal integers should also be considered as a special case of increasing
 * sequence.
 *
 */
public class _491_IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> holder = new ArrayList<>();
		helper(res, holder, 0, nums);
		return new ArrayList<>(res);
	}

	private void helper(Set<List<Integer>> set, List<Integer> list, int index, int[] nums) {
		if (list.size() >= 2) {
			set.add(new ArrayList<>(list));
		}
		for (int i = index; i < nums.length; i++) {
			if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
				list.add(nums[i]);
				helper(set, list, i + 1, nums);
				list.remove(list.size() - 1);
			}
		}
	}
}
