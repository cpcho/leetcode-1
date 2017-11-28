package dfs;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 */
public class _110_BalancedBinaryTree {
	class ResultType {
		boolean isBalanced;
		int maxDepth;

		public ResultType(boolean isBalanced, int maxDepth) {
			this.isBalanced = isBalanced;
			this.maxDepth = maxDepth;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return helper(root).isBalanced;
	}

	// 1.definition
	private ResultType helper(TreeNode root) {
		// 3. exit
		if (root == null) {
			return new ResultType(true, 0);
		}
		// 2 split
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		// subtree not balance
		if (!left.isBalanced || !right.isBalanced) {
			return new ResultType(false, -1);
		}
		// root not balance
		if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new ResultType(false, -1);
		}
		return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
	}
}
