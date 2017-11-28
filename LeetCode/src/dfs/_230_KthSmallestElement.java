package dfs;

/**
 * 
 * Problem:
 * 
 * Given a binary search tree, write a function kthSmallest to find the res
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * 
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the res smallest frequently? How would you optimize the kthSmallest
 * routine?
 *
 */
public class _230_KthSmallestElement {
	private int k;
	private int res;

	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		helper(root);
		return res;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		k--;
		if (k == 0) {
			res = root.val;
			return;
		}
		helper(root.right);
	}
}
