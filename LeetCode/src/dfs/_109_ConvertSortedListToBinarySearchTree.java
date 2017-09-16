package dfs;

/**
 * 
 * Problem: Given a singly linked list where elements are sorted in ascending
 * order, convert it to a height balanced BST.
 *
 */
public class _109_ConvertSortedListToBinarySearchTree {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * Method 1: In order
	 * 
	 * O(N)
	 */
	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int size = 0;
		ListNode runner = head;
		node = head;
		while (runner != null) {
			runner = runner.next;
			size++;
		}
		return dfs(0, size - 1);
	}

	private TreeNode dfs(int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode start = dfs(left, mid - 1);
		TreeNode n = new TreeNode(node.val);
		n.left = start;
		node = node.next; // iterate every node
		TreeNode end = dfs(mid + 1, right);
		n.right = end;
		return n;
	}

	/**
	 * Method 2: Cut the LinkedList
	 * 
	 * O(N*logN)
	 */

	public TreeNode sortedListToBST2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		if (pre != null) {
			pre.next = null; // cur the LinkedList
		} else {
			head = null;
		}
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
}
