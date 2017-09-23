package binarySearch;

/**
 * 
 * Problem:
 * 
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 *
 */
public class _270_ClosestBinarySearchTreeValue {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public int closestValue(TreeNode root, double target) {
		int res = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(res - target)) {
				res = root.val;
			}
			root = root.val > target ? root.left : root.right;
		}
		return res;
	}
}
