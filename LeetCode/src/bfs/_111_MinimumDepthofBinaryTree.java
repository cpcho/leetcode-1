package bfs;

import java.util.*;

/**
 * 
 * Problem: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node. 
 * Time Complexity: 
 * Space Complexity:
 */
public class _111_MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return res;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.left == null && tmp.right == null) {
					return res + 1;
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			res++;
		}
		return res;
	}
}
