package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 * 
 * Example: Given binary tree
 * 
 * ----1
 * 
 * ---/ \
 * 
 * --2 --- 3
 * 
 * / \
 * 
 * 4 -5
 *
 * Returns [4, 5, 3], [2], [1].
 * 
 */
public class _366_FindLeavesofBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	// level of the node.
	private int helper(TreeNode node, List<List<Integer>> res) {
		if (node == null) {
			return -1;
		}
		int level = 1 + Math.max(helper(node.left, res), helper(node.right, res));
		if (res.size() < level + 1) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(node.val);
		return level;
	}
}
