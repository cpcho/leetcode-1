package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Problem:
 * 
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 */
public class _199_BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			list.add(queue.peek().val);
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
			}
		}
		return list;
	}
}
