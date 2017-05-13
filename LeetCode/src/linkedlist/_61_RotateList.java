package linkedlist;

/**
 * 
 * Problem: Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * Algorithm: 
 *  1. find the length, mod
 *  2. right -> k steps, left and right -> (until right is the end)
 *  3. left.next is the new head.
 * 
 * Time Complexity:
 *
 * Space Complexity:
 */
public class _61_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		int size = 0;
		ListNode left = head;
		ListNode right = head;
		ListNode newHead = head;
		while (newHead != null) {
			newHead = newHead.next;
			size++;
		}
		k = k % size;
		if (k == 0) {
			return head;
		}
		while (k > 0) {
			right = right.next;
			k--;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		newHead = left.next;
		left.next = null;
		right.next = head;
		return newHead;
	}
}
