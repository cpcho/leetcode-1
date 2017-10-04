package dfs;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them
 *
 */
public class _687_LongestUnivaluePath {
	private int res = 0;

	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return res;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		int newLeft = 0;
		int newRight = 0;
		if (root.left != null && root.val == root.left.val) {
			newLeft = left + 1;
		}
		if (root.right != null && root.val == root.right.val) {
			newRight = right + 1;
		}
		res = Math.max(res, newLeft + newRight);
		return Math.max(newLeft, newRight);
	}
}
