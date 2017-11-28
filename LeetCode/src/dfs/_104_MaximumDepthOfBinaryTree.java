package dfs;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node
 *
 */
public class _104_MaximumDepthOfBinaryTree {
	/**
	 * Method 1
	 */
	public int maxDepth1(TreeNode root) {
		return helper1(root);
	}

	private int helper1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(helper1(root.left), helper1(root.right)) + 1;
	}

	/**
	 * Method 2
	 */
	int max = 0;

	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper2(root, 0);
		return max;
	}

	private void helper2(TreeNode root, int depth) {
		if (root.left == null && root.right == null) {
			max = Math.max(max, depth + 1);
			return;
		}
		if (root.left != null) {
			helper2(root.left, depth + 1);
		}
		if (root.right != null) {
			helper2(root.right, depth + 1);
		}
	}

	/**
	 * Method 3
	 */
	int max3 = 0;

	public int maxDepth(TreeNode root) {
		traverse(root, 0);
		return max3;
	}

	public void traverse(TreeNode node, int depth) {
		if (depth > max)
			max = depth;
		if (node == null)
			return;
		traverse(node.left, depth + 1);
		traverse(node.right, depth + 1);
	}
}
