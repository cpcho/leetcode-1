package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 *
 *
 */
public class _090_SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		helper(res, list, nums, 0);
		return res;
	}

	private static void helper(List<List<Integer>> result, List<Integer> list, int[] num, int startIndex) {
		result.add(new ArrayList<Integer>(list));
		for (int i = startIndex; i < num.length; i++) {
			// new added remove duplicates
			if (i > startIndex && num[i] == num[i - 1]) {
				continue;
			}
			list.add(num[i]);
			helper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
