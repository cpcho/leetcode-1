package linkedlist;

/**
 * 
 * Problem:
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 */
public class _019_RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode left = head;
		ListNode right = head;
		// make the gap become n, so we can just delete the node after left
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		// delete head;
		if (right == null) {
			return head.next;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return head;
	}
}
