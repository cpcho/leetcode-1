package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Problem: You need to find the largest value in each row of a binary tree.
 * 
 * Time Complexity:
 * 
 * Space Complexity:
 */
public class _515_FindLargestValueinEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int max = Integer.MIN_VALUE;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				max = Math.max(max, tmp.val);
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			list.add(max);
		}
		return list;
	}
}
