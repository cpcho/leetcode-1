package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 *
 */
public class _113_PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		helper(root, sum, cur, res);
		return res;
	}

	private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		cur.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			res.add(new ArrayList<Integer>(cur));
		} else {
			helper(root.left, sum - root.val, cur, res);
			helper(root.right, sum - root.val, cur, res);
		}
		cur.remove(cur.size() - 1);
	}
}
