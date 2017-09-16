package dfs;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 * 1
 *
 * / \
 * 
 * 2 3 Return 6.
 *
 */
public class _124_BinaryTreeMaximumPathSum {
	private int max;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		helper(root);
		return max;
	}

	private int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(0, helper(node.left));
		int right = Math.max(0, helper(node.right));
		max = Math.max(max, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
}
