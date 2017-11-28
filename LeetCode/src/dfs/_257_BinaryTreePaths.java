package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 *
 */
public class _257_BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		StringBuilder sb = new StringBuilder(root.val + "");
		helper(root, res, sb);
		return res;
	}

	private void helper(TreeNode root, List<String> res, StringBuilder sb) {
		if (root.left == null && root.right == null) {
			res.add(sb.toString());
			return;
		}
		int len = sb.length();
		if (root.left != null) {
			sb.append("->");
			sb.append(root.left.val);
			helper(root.left, res, sb);
			sb.setLength(len);
		}
		if (root.right != null) {
			sb.append("->");
			sb.append(root.right.val);
			helper(root.right, res, sb);
			// sb.setLength(len);
		}
	}
}
