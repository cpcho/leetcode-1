package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 */
public class _047_PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null) {
			return res;
		}
		if (nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		Arrays.sort(nums);
		ArrayList<Integer> list = new ArrayList<>();
		int[] visited = new int[nums.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		helper(res, list, visited, nums);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int[] visited, int[] nums) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
				continue;
			}
			visited[i] = 1;
			list.add(nums[i]);
			helper(res, list, visited, nums);
			list.remove(list.size() - 1);
			visited[i] = 0;
		}
	}
}
