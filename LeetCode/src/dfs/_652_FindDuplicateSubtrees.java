package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem:
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 *
 */
public class _652_FindDuplicateSubtrees {
	List<TreeNode> res = new ArrayList<>();
	Map<String, Integer> map = new HashMap<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		helper(root);
		return res;
	}

	private String helper(TreeNode root) {
		if (root == null) {
			return "#";
		}
		String serial = root.val + " " + helper(root.left) + "," + helper(root.right);
		if (map.getOrDefault(serial, 0) == 1) {
			res.add(root);
		}
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
	}
}
