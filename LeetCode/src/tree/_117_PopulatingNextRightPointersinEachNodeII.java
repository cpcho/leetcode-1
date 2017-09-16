package tree;

/**
 * 
 * Problem:
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note: You may only use constant extra space.
 */
public class _117_PopulatingNextRightPointersinEachNodeII {

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode head = null; // head of the next level
		TreeLinkNode prev = null; // head of the next level
		TreeLinkNode cur = root; // current node of current level
		while (cur != null) {
			while (cur != null) { // iterate on the current level
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				// move to next node
				cur = cur.next;
			}
			cur = head;
			head = null;
			prev = null;
		}
	}
}
