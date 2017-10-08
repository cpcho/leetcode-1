package tree;

/**
 * 
 * Problem:
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 */
public class _222_CountCompleteTreeNode {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = leftDepth(root);
		int right = rightDepth(root);
		if (left == right) {
			return (1 << left) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}

	private int leftDepth(TreeNode root) {
		int d = 0;
		while (root != null) {
			root = root.left;
			d++;
		}
		return d;
	}

	private int rightDepth(TreeNode root) {
		int d = 0;
		while (root != null) {
			root = root.right;
			d++;
		}
		return d;
	}
}
