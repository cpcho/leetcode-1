package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author chengfeili 
 * Jun 17, 2017 4:05:01 PM
 * 
 *         Problem:Given a collection of candidate numbers (C) and a target
 *         number (T), find all unique combinations in C where the candidate
 *         numbers sums to T.
 * 
 *         Each number in C may only be used once in the combination.
 * 
 *         Note: All numbers (including target) will be positive integers. The
 *         solution set must not contain duplicate combinations. For example,
 *         given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, A solution
 *         set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 *
 *         Solution:
 * 
 *         Time Complexity:
 * 
 *         Space Complexity:
 *
 */
public class _040_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			// deal with duplicates if there exits [1,1,2] target is 3. so only
			// choose first 1, [1,2]
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			list.add(candidates[i]);
			helper(res, list, candidates, target - candidates[i], i + 1);
			list.remove(list.size() - 1);
		}
	}
}
