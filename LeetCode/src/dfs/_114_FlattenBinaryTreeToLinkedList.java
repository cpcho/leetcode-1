package dfs;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 *
 */
public class _114_FlattenBinaryTreeToLinkedList {
	TreeNode lastNode = null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		if (lastNode == null) {
			lastNode = root;
		} else {
			lastNode.right = root;
			lastNode.left = null;
			lastNode = root;
		}
		// cut the right side
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
}
