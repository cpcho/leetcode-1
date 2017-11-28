package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3] ]
 *
 *
 */
public class _039_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null) {
			return res;
		}
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		helper(res, list, candidates, target, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			// deal with duplicates if there exits
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			list.add(candidates[i]);
			helper(res, list, candidates, target - candidates[i], i);
			list.remove(list.size() - 1);
		}
	}
}
