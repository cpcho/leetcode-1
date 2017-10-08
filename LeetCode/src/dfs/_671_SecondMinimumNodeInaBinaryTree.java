package dfs;

/**
 * 
 * Problem:
 *
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes.
 * 
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 *
 */
public class _671_SecondMinimumNodeInaBinaryTree {
	int min1 = Integer.MAX_VALUE;
	int min2 = Integer.MAX_VALUE;

	public int findSecondMinimumValue(TreeNode root) {
		helper(root);
		return min2 == Integer.MAX_VALUE ? -1 : min2;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		int cur = root.val;
		if (cur < min1) {
			min2 = min1;
			min1 = cur;
		} else if (cur > min1 && cur < min2) {
			min2 = cur;
		}
		helper(root.left);
		helper(root.right);
	}
}
