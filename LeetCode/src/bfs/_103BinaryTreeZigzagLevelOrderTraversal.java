package bfs;

import java.util.*;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 */
public class _103BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return res;
		}
		boolean goRight = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> curRow = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (goRight) {
					curRow.add(tmp.val);
				} else {
					curRow.add(0, tmp.val);
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			goRight = !goRight;
			res.add(curRow);
		}
		return res;
	}
}
