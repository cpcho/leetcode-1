package dfs;

/**
 * 
 * Problem:
 *
 * Given a binary tree with n nodes, your task is to check if it's possible to
 * partition the tree to two trees which have the equal sum of values after
 * removing exactly one edge on the original tree.
 *
 */
public class _663_EqualTreePartition {
	long sum = 0;
	boolean find = false;
	TreeNode r = null;

	public boolean checkEqualTree(TreeNode root) {
		r = root;
		sum = getSum(root);
		getCur(root);
		return find;
	}

	private long getSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		long left = getSum(root.left);
		long right = getSum(root.right);
		return left + root.val + right;
	}

	private long getCur(TreeNode root) {
		if (root == null || find) {
			return 0;
		}
		long left = getCur(root.left);
		long right = getCur(root.right);
		long cur = left + root.val + right;
		if (cur + cur == sum && root != r) {
			find = true;
			return 0;
		}
		return cur;
	}
}
