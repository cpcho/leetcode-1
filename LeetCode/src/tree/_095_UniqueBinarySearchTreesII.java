package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1...n.
 * 
 */
public class _095_UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return new ArrayList<TreeNode>();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int left, int right) {
		List<TreeNode> res = new ArrayList<>();
		if (left > right) {
			res.add(null);
			return res;
		}
		if (left == right) {
			res.add(new TreeNode(left));
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> l = helper(left, i - 1);
			List<TreeNode> r = helper(i + 1, right);
			for (TreeNode leftN : l) {
				for (TreeNode rightN : r) {
					TreeNode root = new TreeNode(i);
					root.left = leftN;
					root.right = rightN;
					res.add(root);
				}
			}
		}
		return res;
	}
}
