package dfs;

/**
 * 
 * Problem: Given an array where elements are sorted in ascending order, convert
 * it to a height balanced BST.
 *
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		TreeNode head = helper(nums, 0, nums.length - 1);
		return head;
	}

	private TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}
}
