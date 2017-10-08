package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 *
 * Given a binary tree, write a function to get the maximum width of the given
 * tree. The width of a tree is the maximum width among all levels. The binary
 * tree has the same structure as a full binary tree, but some nodes are null.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 *
 */
public class _662_MaximumWidthofBinaryTree {
	List<Integer> start = new ArrayList<>();
	List<Integer> end = new ArrayList<>();

	public int widthOfBinaryTree(TreeNode root) {
		return helper(root, 0, 1);
	}

	private int helper(TreeNode root, int level, int order) {
		if (root == null) {
			return 0;
		}
		if (start.size() == level) {
			start.add(order);
			end.add(order);
		} else {
			end.set(level, order);
		}
		int cur = end.get(level) - start.get(level) + 1;
		int left = helper(root.left, level + 1, 2 * order);
		int right = helper(root.right, level + 1, 2 * order + 1);
		return Math.max(cur, Math.max(left, right));
	}
}
