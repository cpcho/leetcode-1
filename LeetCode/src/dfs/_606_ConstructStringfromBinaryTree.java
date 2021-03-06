package dfs;

/**
 * 
 * Problem:
 *
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And you
 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 * 
 */
public class _606_ConstructStringfromBinaryTree {
	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		String res = "" + t.val;
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		if (left == "" && right == "") {
			return res;
		}
		if (left == "") {
			return res + "()" + "(" + right + ")";
		}
		if (right == "") {
			return res + "(" + left + ")";
		}
		return res + "(" + left + ")" + "(" + right + ")";
	}
}
