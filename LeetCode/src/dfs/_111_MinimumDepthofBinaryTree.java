package dfs;

/**
 * 
 * Problem: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node. 
 * Time Complexity: 
 * Space Complexity:
 */
public class _111_MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		// if both left and right child are not null, use the min
		// if one of them are null, use the non-null child
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
}
