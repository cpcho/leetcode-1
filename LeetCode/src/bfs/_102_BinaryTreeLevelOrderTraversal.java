package bfs;

import java.util.*;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class _102_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return res;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> curRow = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				curRow.add(tmp.val);
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			res.add(curRow);
		}
		return res;
	}
}
