package tree;

/**
 * 
 * Problem:
 *
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * 
 * 1.The root is the maximum number in the array.
 * 
 * 2.The left subtree is the maximum tree constructed from left part subarray
 * divided by the maximum number.
 * 
 * 
 * 3.The right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number.
 * 
 * Construct the maximum tree by the given array and output the root node of
 * this tree.
 *
 */
public class _654_MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int index = getIndex(nums, left, right);
		TreeNode root = new TreeNode(nums[index]);
		root.left = helper(nums, left, index - 1);
		root.right = helper(nums, index + 1, right);
		return root;
	}

	private int getIndex(int[] nums, int left, int right) {
		int index = left;
		int max = nums[left];
		for (int i = left; i <= right; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		return index;
	}
}
