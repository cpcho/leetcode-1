package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 */
public class _513_FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			res = queue.peek().val;
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
		}
		return res;
	}
}
