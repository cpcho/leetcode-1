package dfs;

/**
 * 
 * Problem: Given a binary tree, check whether it is a mirror of itself
 *  (ie, symmetric around its center).
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
public class _101_SysmmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return root == null || helper(root.left, root.right);
	}
	
	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}
