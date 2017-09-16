package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given preorder and inorder traversal of a tree, construct the binary
 * tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 *
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		int inIndex = 0;
		TreeNode root = new TreeNode(preorder[preStart]);
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	/**
	 * Method 2: use HashMap to save time
	 */

	public TreeNode buildTree2(int[] preorder, int[] inorder) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(0, 0, inorder.length - 1, preorder, inorder, map);
	}

	private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,
			Map<Integer, Integer> map) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = map.get(root.val);
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder, map);
		// inIndex - inStart = number of nodes on the left
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, map);

		return root;
	}
}
