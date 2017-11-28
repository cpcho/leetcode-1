package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 */
public class _078_Subsets {
	/**
	 * method 1:
	 */
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		// add an empty list
		res.add(list);
		// Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			// can not set j < res.size() in the inner for loop
			int k = res.size();
			for (int j = 0; j < k; j++) {
				list = new ArrayList<Integer>(res.get(j));
				list.add(nums[i]);
				res.add(new ArrayList<Integer>(list));
			}
		}
		return res;
	}

	/**
	 * method 2: DFS
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		ArrayList<Integer> cur = new ArrayList<>();
		helper(res, cur, nums, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int startIndex) {
		res.add(new ArrayList<Integer>(cur));
		for (int i = startIndex; i < nums.length; i++) {
			cur.add(nums[i]);
			helper(res, cur, nums, i + 1);
			cur.remove(cur.size() - 1);
		}
	}
}
