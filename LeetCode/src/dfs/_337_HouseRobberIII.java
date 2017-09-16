package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem:
 * 
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 *
 */
public class _337_HouseRobberIII {
	public int rob(TreeNode root) {
		return helper(root, new HashMap<>());
	}

	private int helper(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}
		// map is used to prevent duplicate calculations
		if (map.containsKey(root)) {
			return map.get(root);
		}
		int val = 0;
		if (root.left != null) {
			val += helper(root.left.left, map) + helper(root.left.right, map);
		}
		if (root.right != null) {
			val += helper(root.right.left, map) + helper(root.right.right, map);
		}
		val = Math.max(val + root.val, helper(root.left, map) + helper(root.right, map));
		map.put(root, val);
		return val;
	}
}
