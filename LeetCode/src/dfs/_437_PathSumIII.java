package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: You are given a binary tree in which each node contains an integer
 * value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 *
 */
public class _437_PathSumIII {
	private int count = 0;

	public int pathSum1(TreeNode root, int sum) {
		Map<Integer, Integer> preSum = new HashMap<>();
		// must have
		preSum.put(0, 1);
		helper1(root, 0, sum, preSum);
		return count;
	}

	private void helper1(TreeNode root, int curSum, int target, Map<Integer, Integer> preSum) {
		if (root == null) {
			return;
		}
		curSum += root.val;
		if (preSum.containsKey(curSum - target)) {
			count += preSum.get(curSum - target);
		}
		if (!preSum.containsKey(curSum)) {
			preSum.put(curSum, 1);
		} else {
			preSum.put(curSum, preSum.get(curSum) + 1);
		}
		helper1(root.left, curSum, target, preSum);
		helper1(root.right, curSum, target, preSum);
		preSum.put(curSum, preSum.get(curSum) - 1);
	}

	public int pathSum2(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return helper2(root, 0, sum, map);
	}

	private int helper2(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		curSum += root.val;
		int res = 0;
		if (map.containsKey(curSum - target)) {
			res = map.get(curSum - target);
		}
		map.put(curSum, map.getOrDefault(curSum, 0) + 1);
		res += helper2(root.left, curSum, target, map) + helper2(root.right, curSum, target, map);
		map.put(curSum, map.get(curSum) - 1);
		return res;
	}
}
